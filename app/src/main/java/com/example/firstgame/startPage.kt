package com.example.firstgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_start_page.*
import kotlin.random.Random

class startPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start_page)
         arif()

    }

        fun arif(){
            var a = Random.nextInt(0, 99)
            var b = Random.nextInt(0, 99)
            var c = Random.nextInt(1, 4)
            var result = 0
            when (c) {
                1 -> tvQuestion2.text = " $a+$b"
                2 -> tvQuestion2.text = " $a-$b"
                3 -> tvQuestion2.text = "$a*$b"
                else -> tvQuestion2.text = "$a/$b"
            }
            if (c == 1) {
                result = a + b

                btn1.text = Random.nextInt(5, result + 5).toString()
                btn4.text = Random.nextInt(5, result + 1).toString()
                btn3.text = Random.nextInt(5, result + 10).toString()
                btn2.text = "$result"

            } else if (c == 2) {
                result = a - b
                btn1.text = "$result"
                btn2.text = Random.nextInt(5, result + 5).toString()
                btn4.text = Random.nextInt(5, result + 1).toString()
                btn3.text = Random.nextInt(5, result + 10).toString()
            } else if (c == 3) {
                result = a * b
                btn4.text = "$result"
                btn1.text = Random.nextInt(5, result + 5).toString()
                btn2.text = Random.nextInt(5, result + 1).toString()
                btn3.text = Random.nextInt(5, result + 10).toString()
            } else if (c == 4) {
                result = a / b
                btn3.text = "$result"
                btn1.text = Random.nextInt(5, result + 5).toString()
                btn4.text = Random.nextInt(5, result + 1).toString()
                btn2.text = Random.nextInt(5, result + 10).toString()
            }

        }
    }







