package com.example.rebootBook

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

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

            resultTextView.text = "결과: $mesoResult" + "만큼 벌 수 있습니다."
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

    private fun calculateMeso(
        characterLevel: Double, monsterLevel: Double,
        sixMinuteCount: Double, mesoGain: Double,
        wealthPotion: Boolean
    ): Double {
        val wealthPotionMultiplier = if (wealthPotion) 1.2 else 1.0
        return monsterLevel * 7.5 * mesoGain * wealthPotionMultiplier * sixMinuteCount * 5
    }
}
