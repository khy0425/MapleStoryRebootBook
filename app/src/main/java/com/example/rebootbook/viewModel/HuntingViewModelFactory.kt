package com.example.rebootBook.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HuntingViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HuntingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HuntingViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
