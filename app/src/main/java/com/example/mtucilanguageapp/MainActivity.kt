package com.example.mtucilanguageapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var dotsLayout: LinearLayout
    private lateinit var dots: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        viewPager = findViewById(R.id.slideViewPager)
        dotsLayout = findViewById(R.id.indicator_layout)
        dots = arrayOfNulls(3)

        viewPager.adapter = CustomPageAdapter(this)
        setupIndicator(0)
        viewPager.addOnPageChangeListener(viewListener)

        findViewById<Button>(R.id.nextbtn).setOnClickListener {
            if (viewPager.currentItem < 2) {
                viewPager.setCurrentItem(viewPager.currentItem + 1, true)
            } else {
                startActivity(Intent(this, LogInActivity::class.java))
                finish()
            }
        }

        findViewById<Button>(R.id.skipButton).setOnClickListener {
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
    }

    private fun setupIndicator(position: Int) {
        dotsLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this).apply {
                text = "o"
                textSize = 35f
                setTextColor(resources.getColor(R.color.purple_200, theme))
                dotsLayout.addView(this)
            }
        }
        dots[position]?.setTextColor(resources.getColor(R.color.background, theme))
    }

    private val viewListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) = setupIndicator(position)
        override fun onPageScrollStateChanged(state: Int) {}
    }
}
