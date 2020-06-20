package com.rfthrlrts.kahitdoslang

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*
import android.net.Uri

class GameActivity : AppCompatActivity() {

    var Answer : String = ""
    var Score : Int = 0

    var Count : Int = 0
    var TLInterval : Long = 5000
    var SensitivityX : Int = 2
    var SensitivityY : Int = 5

    var GameOver : Boolean = false

    var tmr_TimeLimit = object : CountDownTimer(TLInterval, 100) {
        override fun onTick(l: Long) {
            Count+=100
            progressBar.progress = Count
//            if ((Count==500) or (Count==1000) or (Count==1500) or (Count==2000) or (Count==2500) or (Count==3000) or (Count==3500) or (Count==4000) or (Count==4500)) {
                var RN0 : Int = Random().nextInt(3 - 1) + 1
                var RN1 : Int = Random().nextInt(SensitivityX - 1) + 1
                var RN2 : Int = Random().nextInt(SensitivityY - 1) + 1
                if (RN0 == 1) {
                    text_Color.setPadding(RN1,RN2,0,0)
                }
                else if (RN0 == 2) {
                    text_Color.setPadding(0,0,RN1,RN2)
                }
//            }
        }
        override fun onFinish() {
            GameOver = true
            timeLimit()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        Layout.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        button_Left.setOnClickListener { buttonLeftClick() }
        button_Right.setOnClickListener { buttonRightClick() }
        text_Score.text = Score.toString()
        text_Color.text = ""
        generateNewColor()
        timeLimitReset()
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.glitch)
        videoView.setVideoURI(uri)
        videoView.setOnPreparedListener { mp -> mp.isLooping = true }
        videoView.start()
//        CDT.start()
    }

    fun buttonLeftClick() {
        if (Answer == "Left") {
            Score+=1
            text_Score.text = Score.toString()
            checkLevel()
            generateNewColor()
            timeLimitReset()
        }
        else {
            tmr_TimeLimit.cancel()
            GameOver = true
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("ScoreValue", Score.toString())
            startActivity(intent)
        }
    }

    fun buttonRightClick() {
        if (Answer == "Right") {
            Score+=1
            text_Score.text = Score.toString()
            checkLevel()
            generateNewColor()
            timeLimitReset()
        }
        else {
            tmr_TimeLimit.cancel()
            GameOver = true
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("ScoreValue", Score.toString())
            startActivity(intent)
        }
    }

    fun checkLevel() {
        if (Score >= 50) {
            SensitivityX = 1000
            SensitivityY = 5000
        }
        else if (Score >= 40) {
            SensitivityX = 750
            SensitivityY = 3750
        }
        else if (Score >= 30) {
            SensitivityX = 500
            SensitivityY = 2500
        }
        else if (Score >= 20) {
            SensitivityX = 250
            SensitivityY = 1250
        }
        else if (Score >= 10) {
            SensitivityX = 10
            SensitivityY = 50
        }
    }

    fun generateNewColor() {
        var RN0 : Int = Random().nextInt(3 - 1) + 1
        if (RN0 == 1) {
            Answer = "Left"
            var RN1 : Int = Random().nextInt(7 - 1) + 1
            var RN2 : Int = Random().nextInt(6 - 1) + 1
            if (RN1 == 1) {
                text_Color.setTextColor(Color.rgb(255,0,0))
                if (RN2 == 1) {
                    text_Color.text = "cyan"
                }
                else if (RN2 == 2) {
                    text_Color.text = "green"
                }
                else if (RN2 == 3) {
                    text_Color.text = "blue"
                }
                else if (RN2 == 4) {
                    text_Color.text = "yellow"
                }
                else if (RN2 == 5) {
                    text_Color.text = "magenta"
                }
            }
            else if (RN1 == 2) {
                text_Color.setTextColor(Color.rgb(0,255,0))
                if (RN2 == 1) {
                    text_Color.text = "cyan"
                }
                else if (RN2 == 2) {
                    text_Color.text = "red"
                }
                else if (RN2 == 3) {
                    text_Color.text = "blue"
                }
                else if (RN2 == 4) {
                    text_Color.text = "yellow"
                }
                else if (RN2 == 5) {
                    text_Color.text = "magenta"
                }
            }
            else if (RN1 == 3) {
                text_Color.setTextColor(Color.rgb(0,0,255))
                if (RN2 == 1) {
                    text_Color.text = "cyan"
                }
                else if (RN2 == 2) {
                    text_Color.text = "green"
                }
                else if (RN2 == 3) {
                    text_Color.text = "red"
                }
                else if (RN2 == 4) {
                    text_Color.text = "yellow"
                }
                else if (RN2 == 5) {
                    text_Color.text = "magenta"
                }
            }
            else if (RN1 == 4) {
                text_Color.setTextColor(Color.rgb(255,255,0))
                if (RN2 == 1) {
                    text_Color.text = "cyan"
                }
                else if (RN2 == 2) {
                    text_Color.text = "green"
                }
                else if (RN2 == 3) {
                    text_Color.text = "blue"
                }
                else if (RN2 == 4) {
                    text_Color.text = "red"
                }
                else if (RN2 == 5) {
                    text_Color.text = "magenta"
                }
            }
            else if (RN1 == 5) {
                text_Color.setTextColor(Color.rgb(255,0,255))
                if (RN2 == 1) {
                    text_Color.text = "cyan"
                }
                else if (RN2 == 2) {
                    text_Color.text = "green"
                }
                else if (RN2 == 3) {
                    text_Color.text = "blue"
                }
                else if (RN2 == 4) {
                    text_Color.text = "yellow"
                }
                else if (RN2 == 5) {
                    text_Color.text = "red"
                }
            }
            else if (RN1 == 6) {
                text_Color.setTextColor(Color.rgb(0,255,255))
                if (RN2 == 1) {
                    text_Color.text = "red"
                }
                else if (RN2 == 2) {
                    text_Color.text = "green"
                }
                else if (RN2 == 3) {
                    text_Color.text = "blue"
                }
                else if (RN2 == 4) {
                    text_Color.text = "yellow"
                }
                else if (RN2 == 5) {
                    text_Color.text = "magenta"
                }
            }
        }
        else if (RN0 == 2) {
            Answer = "Right"
            var RN1 : Int = Random().nextInt(7 - 1) + 1
            if (RN1 == 1) {
                text_Color.setTextColor(Color.rgb(255,0,0))
                text_Color.text = "red"
            }
            else if (RN1 == 2) {
                text_Color.setTextColor(Color.rgb(0,255,0))
                text_Color.text = "green"
            }
            else if (RN1 == 3) {
                text_Color.setTextColor(Color.rgb(0,0,255))
                text_Color.text = "blue"
            }
            else if (RN1 == 4) {
                text_Color.setTextColor(Color.rgb(255,255,0))
                text_Color.text = "yellow"
            }
            else if (RN1 == 5) {
                text_Color.setTextColor(Color.rgb(255,0,255))
                text_Color.text = "magenta"
            }
            else if (RN1 == 6) {
                text_Color.setTextColor(Color.rgb(0,255,255))
                text_Color.text = "cyan"
            }
        }
    }

    fun timeLimitReset() {
        tmr_TimeLimit.cancel()
        progressBar.progress = 0
        Count = 0
        TLInterval = 5000
        tmr_TimeLimit.start()
    }

    fun timeLimit() {
        if (GameOver) {
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra("ScoreValue", Score.toString())
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        if (GameOver == false ) {
            tmr_TimeLimit.cancel()
            val intent = Intent(this, PauseActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        videoView.start()
        tmr_TimeLimit.start()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }



}
