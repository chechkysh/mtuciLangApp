package com.example.mtucilanguageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SelectLanguageActivity : AppCompatActivity() {

    private var selectedLang = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_select)

        setupWindowInsets()

        val russianButton: LinearLayout = findViewById(R.id.russianbtn)
        val englishButton: LinearLayout = findViewById(R.id.englishbtn)
        val selectLanguageButton: Button = findViewById(R.id.choosebtn)

        russianButton.setOnClickListener {
            selectedLang = "ru"
            updateButtonBackgrounds(russianButton, englishButton)
        }

        englishButton.setOnClickListener {
            selectedLang = "en"
            updateButtonBackgrounds(englishButton, russianButton)
        }

        selectLanguageButton.setOnClickListener {
            if (selectedLang.length == 2) {
                startActivity(Intent(this, HomePageActivity::class.java))
                finish()
            }
        }
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.language_select)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun updateButtonBackgrounds(selectedButton: LinearLayout, otherButton: LinearLayout) {
        selectedButton.setBackgroundResource(R.drawable.rounded_button_orange_m)
        otherButton.setBackgroundResource(R.drawable.rounded_m)
    }
}
