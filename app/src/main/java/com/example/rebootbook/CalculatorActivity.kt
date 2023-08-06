package com.example.rebootBook

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.rebootBook.databinding.ActivityCalculatorBinding
import java.lang.Math.abs

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        setContentView(binding.root)

        initViews(binding)

        binding.calculateButton.setOnClickListener {
            val characterLevel = binding.characterLevelEditText.text.toString().toDoubleOrNull() ?: 0.0
            val monsterLevel = binding.monsterLevelEditText.text.toString().toDoubleOrNull() ?: 0.0
            val sixMinuteCount = binding.sixMinuteCountEditText.text.toString().toDoubleOrNull() ?: 0.0
            val mesoGain = binding.mesoDropRateTextView.text.toString().toDoubleOrNull() ?: 0.0
            val wealthPotion = binding.wealthPotionCheckbox.isChecked

            val mesoResult = calculateMeso(
                characterLevel, monsterLevel, sixMinuteCount,
                mesoGain, wealthPotion
            )

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)

            val resultText = formatMeso(mesoResult)
            binding.resultTextView.text = "결과: $resultText"
        }

        var isDescriptionShown = false
        binding.descriptionButton.setOnClickListener {
            isDescriptionShown = !isDescriptionShown
            if (isDescriptionShown) {
                binding.descriptionText.visibility = View.VISIBLE
            } else {
                binding.descriptionText.visibility = View.GONE
            }
        }

    }

    private fun initViews(binding: ActivityCalculatorBinding) {
        // Set up toolbar with back button
        setSupportActionBar(binding.toolbarWithBackButton.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.toolbarWithBackButton.toolbar.setNavigationOnClickListener {
            // Navigate back to MainActivity
            onBackPressed()
        }
    }


    private fun calculateMeso(characterLevel: Double, monsterLevel: Double,
                              sixMinuteCount: Double, mesoGain: Double,
                              wealthPotion: Boolean): Double {
        val wealthPotionMultiplier = if (wealthPotion) 1.2 else 1.0
        val levelDifference = (monsterLevel - characterLevel).toInt()

        val penaltyPercent = when {
            levelDifference >= 30 -> -1.0
            levelDifference <= -34 -> -1.0
            else -> {
                val penaltyTable = arrayOf(
                    -0.97, -0.84, -0.76, -0.65, -0.55,
                    -0.46, -0.38, -0.31, -0.25, -0.2,
                    -0.18, -0.16, -0.14, -0.12, -0.1,
                    -0.08, -0.06, -0.04, -0.02, 0.0,
                    -0.03, -0.06, -0.09, -0.12, -0.15,
                    -0.18, -0.21, -0.24, -0.27, -0.3,
                    -0.35, -0.4, -0.45, -0.5, -0.55,
                    -0.6, -0.65, -0.7, -0.75, -0.8,
                    -0.85, -0.9, -0.95, -1.0
                )
                penaltyTable[levelDifference + 33]
            }
        }

        return (1.0 + penaltyPercent) * monsterLevel * 7.7 * mesoGain / 100 * (sixMinuteCount * 20 ) * wealthPotionMultiplier * 5
    }

    private fun formatMeso(meso: Double): String {
        val absMeso = abs(meso)
        val mesoInt = absMeso.toLong()

        val billion = mesoInt / 1_0000_0000
        val million = (mesoInt % 1_0000_0000) / 1_0000
        val thousand = mesoInt % 1_0000

        val result = StringBuilder("두 시간 동안 ")

        if (billion > 0) {
            result.append("${billion}억 ")
        }
        if (million > 0) {
            result.append("${million}만 ")
        }
        if (thousand > 0) {
            result.append("${thousand} ")
        }

        result.append("메소를 획득하실 수 있습니다.")

        return result.toString()
    }
}
