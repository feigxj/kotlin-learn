package com.qiushui.blurredviewdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

import java.util.Collections

/**
 * Demo
 * @author Qiushui
 */
class MainActivity : AppCompatActivity() {

    /**
     * basic btn
     */
    private var mBasicBtn: Button? = null

    /**
     * weather btn
     */
    private var mWeatherBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        mBasicBtn = findViewById<View>(R.id.basic_blur_btn) as Button
        mWeatherBtn = findViewById<View>(R.id.weather_blur_btn) as Button

        mBasicBtn!!.setOnClickListener { startActivity(Intent(this@MainActivity, BlurredViewBasicActivity::class.java)) }

        mWeatherBtn!!.setOnClickListener { startActivity(Intent(this@MainActivity, WeatherActivity::class.java)) }
        val list = listOf("aaa")

    }
}
