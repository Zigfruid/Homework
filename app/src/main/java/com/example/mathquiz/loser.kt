package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_loser.*

class loser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loser)
        btnRetry.setOnClickListener {
            intent = Intent(this, StartGameActivity::class.java)
            startActivity(intent)
            finish()
        }
        btnRetryEnd.setOnClickListener {
            finish()
        }
    }

}
