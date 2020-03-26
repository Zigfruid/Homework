package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart.setOnClickListener {
           val nextPage = Intent(this, StartGameActivity::class.java)
            startActivity(nextPage)
        }
        btnEnd.setOnClickListener {
            finish()
            closeContextMenu()
        }
    }
}
