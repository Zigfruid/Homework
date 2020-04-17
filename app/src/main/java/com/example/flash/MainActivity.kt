package com.example.flash

import android.animation.AnimatorInflater
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var playOn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.from_right)
        loadAnimator.setTarget(ivFlash)

        loadAnimator.start()

        btn.setOnClickListener {
            if (playOn){
                playOn=false
                btn.setImageResource(R.drawable.ic_pause_black_24dp)
                loadAnimator.resume()
        }else{
                playOn = true
                btn.setImageResource(R.drawable.ic_play_arrow_black_24dp)
                loadAnimator.pause()
            }

        }
    }
}
