package com.leaf.rebootBook

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leaf.rebootBook.databinding.ActivityCalculatorBinding

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
            val unionPotion = binding.unionPotionCheckbox.isChecked  // 유니온의 부 체크박스 상태

            val mesoResult = calculateMeso(
                characterLevel, monsterLevel, sixMinuteCount,
                mesoGain, wealthPotion, unionPotion
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
                              wealthPotion: Boolean, unionPotion: Boolean): Double {
        val wealthPotionMultiplier = if (wealthPotion) 1.2 else 1.0
        val unionPotionMultiplier = if (unionPotion) 1.5 else 1.0  // 유니온의 부 적용

        val levelDifference = (monsterLevel - characterLevel).toInt()

        val penaltyPercent = when {
            levelDifference >= 34 -> 0.0
            levelDifference <= -30 -> 0.0
            else -> {
                val penaltyTable = arrayOf(
                    0.05, 0.1, 0.15, 0.2, 0.25, 0.3, 0.35, 0.4, 0.45, 0.5,
                    0.55, 0.6, 0.65, 0.7, 0.75, 0.8, 0.85, 0.9, 0.95, 1.0,
                    1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
                    0.98, 0.96, 0.94, 0.92, 0.9, 0.88, 0.86, 0.84, 0.82, 0.8,
                    0.78, 0.76, 0.74, 0.72, 0.7, 0.68, 0.66, 0.64, 0.62, 0.6,
                    0.58, 0.56, 0.54, 0.52, 0.5, 0.48, 0.46, 0.44, 0.42, 0.4,
                    0.38, 0.36, 0.34, 0.32, 0.3, 0.28, 0.26, 0.24, 0.22, 0.2,
                    0.18, 0.16, 0.14, 0.12, 0.1, 0.08, 0.06, 0.04, 0.02
                )
                penaltyTable[levelDifference + 33]
            }
        }


        val coeff = 1.5  // 수정된 계수값
        val mesoPerMonster = monsterLevel * coeff * 5 * (100 + mesoGain) / 100 * wealthPotionMultiplier * unionPotionMultiplier

        return penaltyPercent * mesoPerMonster * sixMinuteCount * 20
    }

    private fun formatMeso(meso: Double): String {
        val absMeso = kotlin.math.abs(meso)
        val mesoInt = absMeso.toLong()

        val billion = mesoInt / 1_0000_0000
        val million = (mesoInt % 1_0000_0000) / 1_0000
        val thousand = mesoInt % 1_0000

        val result = StringBuilder("두 시간 동안 약 ")

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