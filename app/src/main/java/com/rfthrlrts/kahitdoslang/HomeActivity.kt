package com.rfthrlrts.kahitdoslang

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import android.content.Intent



class HomeActivity : AppCompatActivity() {

    var CDT = object : CountDownTimer(150, 150) {
        override fun onTick(l: Long) {
            var RN0 : Int = Random().nextInt(3 - 1) + 1
            var RN1 : Int = Random().nextInt(25 - 1) + 1
            var RN2 : Int = Random().nextInt(125 - 1) + 1
            var RN3 : Int = Random().nextInt(7 - 1) + 1
            if (RN0 == 1) {
                text_Start.setPadding(RN1,RN2,0,0)
            }
            else if (RN0 == 2) {
                text_Start.setPadding(0,0,RN1,RN2)
            }
            if (RN3 == 1) {
                text_Start.setTextColor(Color.rgb(255,0,0))
            }
            else if (RN3 == 2) {
                text_Start.setTextColor(Color.rgb(0,255,0))
            }
            else if (RN3 == 3) {
                text_Start.setTextColor(Color.rgb(0,0,255))
            }
            else if (RN3 == 4) {
                text_Start.setTextColor(Color.rgb(255,255,0))
            }
            else if (RN3 == 5) {
                text_Start.setTextColor(Color.rgb(255,0,255))
            }
            else if (RN3 == 6) {
                text_Start.setTextColor(Color.rgb(0,255,255))
            }
        }
        override fun onFinish() {
            this.start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Layout.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        button_Start.setOnClickListener{
            finish()
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        CDT.start()
    }
}
