package com.example.mtucilanguageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class CustomPageAdapter(private val appContext: Context) : PagerAdapter() {

    override fun getCount() = SlideResources.slideTitles.size

    override fun isViewFromObject(view: View, obj: Any) = view === obj as LinearLayout

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(appContext)
        val slideView = inflater.inflate(R.layout.slider_layout, container, false)

        val titleImage: ImageView = slideView.findViewById(R.id.titleImage)
        val slideTitle: TextView = slideView.findViewById(R.id.texttitle)
        val slideDesc: TextView = slideView.findViewById(R.id.textdescription)

        titleImage.setImageResource(SlideResources.slideImages[position])
        slideTitle.setText(SlideResources.slideTitles[position])
        slideDesc.setText(SlideResources.slideDescriptions[position])

        container.addView(slideView)
        return slideView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as LinearLayout)
    }
}
