package com.example.rebootBook

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.lang.Math.abs

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        initViews()

        val characterLevelEditText: EditText = findViewById(R.id.character_level_edit_text)
        val monsterLevelEditText: EditText = findViewById(R.id.monster_level_edit_text)
        val sixMinuteCountEditText: EditText = findViewById(R.id.six_minute_count_edit_text)
        val mesoGainEditText: EditText = findViewById(R.id.meso_drop_rate_text_view)
        val wealthPotionCheckbox: CheckBox = findViewById(R.id.wealth_potion_checkbox)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val calculationDescriptionButton: Button = findViewById(R.id.description_button)
        val descriptionText: TextView = findViewById(R.id.description_text)
        val resultTextView: TextView = findViewById(R.id.result_text_view)

        calculateButton.setOnClickListener {
            val characterLevel = characterLevelEditText.text.toString().toDoubleOrNull() ?: 0.0
            val monsterLevel = monsterLevelEditText.text.toString().toDoubleOrNull() ?: 0.0
            val sixMinuteCount = sixMinuteCountEditText.text.toString().toDoubleOrNull() ?: 0.0
            val mesoGain = mesoGainEditText.text.toString().toDoubleOrNull() ?: 0.0
            val wealthPotion = wealthPotionCheckbox.isChecked

            val mesoResult = calculateMeso(
                characterLevel, monsterLevel, sixMinuteCount,
                mesoGain, wealthPotion
            )

            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)

            val resultText = formatMeso(mesoResult)
            resultTextView.text = "결과: $resultText"
        }

        var isDescriptionShown = false
        calculationDescriptionButton.setOnClickListener {
            isDescriptionShown = !isDescriptionShown
            if (isDescriptionShown) {
                descriptionText.visibility = View.VISIBLE
            } else {
                descriptionText.visibility = View.GONE
            }
        }

    }

    private fun initViews() {
        // Set up toolbar with back button
        val toolbar = findViewById<Toolbar>(R.id.toolbar_with_back_button)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setNavigationOnClickListener {
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
