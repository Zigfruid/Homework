package com.example.mathquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_start_game.*
import kotlin.random.Random

var result = 0
var count = 0
const val numberOfQuestion =  9
class startgame : AppCompatActivity() {
    private var list: MutableList<Int> = arrayListOf()
    var a = Random.nextInt(0, 100)
    var b = Random.nextInt(0, 100)
    var c = Random.nextInt(0, 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
        game()
        tvCount.text = "Уровень : $count"
    }

    private fun game() {
        tvMain.text = when (c) {
            1 -> "$a+$b"
            2 -> "$a-$b"
            3 -> "$a*$b"
            else -> "$a/$b"
        }
        when (c) {
            1 -> {
                result = a + b
                btn1.text = "$result"
                btn2.text = Random.nextInt(5, result + 10).toString()
                btn3.text = Random.nextInt(5, result + 6).toString()
                btn4.text = Random.nextInt(5, result + 7).toString()
            }
            2 -> {
                result = a - b
                btn2.text = "$result"
                btn1.text = Random.nextInt(5, result + 10).toString()
                btn3.text = Random.nextInt(5, result - 6).toString()
                btn4.text = Random.nextInt(5, result + 7).toString()
            }
            3 -> {
                result = a * b
                btn3.text = "$result"
                btn2.text = Random.nextInt(5, result + 11).toString()
                btn1.text = Random.nextInt(5, result + 6).toString()
                btn4.text = Random.nextInt(5, result + 2).toString()
            }
            else -> {
                result = a / b
                btn4.text = "$result"
                btn2.text = Random.nextInt(5, result + 8).toString()
                btn3.text = Random.nextInt(5, result + 6).toString()
                btn1.text = Random.nextInt(5, result + 7).toString()
            }
        }
    }


    fun onclick(it: View) {
        val button = it as Button
        val pressedButton = button.text.toString().toInt()
        if (pressedButton == result) {
            if (count == numberOfQuestion) {
                val intent = Intent(this, winner::class.java)
                startActivity(intent)
            }
            Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
            count++
            tvCount.text = "Уровень : $count"
        } else {
            Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
            button.setOnClickListener {
                val intent = Intent(this, loser::class.java)
                startActivity(intent)
            }
        }
        game()
    }
}

