package com.leaf.rebootBook

import android.content.Context
import android.os.Build
import android.util.Base64
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
class KeyManager(private val context: Context) {

    private val keyAlias = "MySecretKeyAlias"
    private val keyStore = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }

    init {
        if (!keyStore.containsAlias(keyAlias)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
            val keySpec = KeyGenParameterSpec.Builder(keyAlias,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .build()
            keyGenerator.init(keySpec)
            keyGenerator.generateKey()
        }
    }

    fun encrypt(data: String): String {
        val key = keyStore.getKey(keyAlias, null) as SecretKey
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        return Base64.encodeToString(cipher.doFinal(data.toByteArray(Charsets.UTF_8)), Base64.DEFAULT)
    }

    fun decrypt(data: String): String {
        val key = keyStore.getKey(keyAlias, null) as SecretKey
        val cipher = Cipher.getInstance("AES/CBC/PKCS7Padding")
        val iv = cipher.parameters.getParameterSpec(IvParameterSpec::class.java).iv
        cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(iv))
        return cipher.doFinal(Base64.decode(data, Base64.DEFAULT)).toString(Charsets.UTF_8)
    }

    fun saveKey(keyName: String, encryptedData: String) {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(keyName, encryptedData).apply()
    }

    fun loadKey(keyName: String): String? {
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString(keyName, null)
    }
}
