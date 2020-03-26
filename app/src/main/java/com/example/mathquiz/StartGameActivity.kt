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
const val numberOfQuestion =  10

class startgame : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)
        game()
        count++
        tvCount.text = "Уровень : $count"
    }

    private fun game() {
        var a = Random.nextInt(0, 100)
        var b = Random.nextInt(0, 100)
        var c = Random.nextInt(0, 4)
        tvMain.text = when (c) {
            1 -> "$a+$b"
            2 -> "$a-$b"
            3 -> "$a*$b"
            else -> "$a/$b"
        }
        result = when (c) {
            1 -> a + b
            2 -> a - b
            3 -> a * b
            else -> a / b
        }
        val d = Random.nextInt(1, result + 2)
        val e = Random.nextInt(3, result * 4)
        val f = Random.nextInt(5, result / 2)
        val j = Random.nextInt(7, result - 1)

        val r = Random.nextInt(0, 4)
        val group = arrayListOf<Button>(btn1, btn3, btn3, btn4)
        btn1.text = "$d"
        btn2.text = "$e"
        btn3.text = "$f"
        btn4.text = "$j"
        group[r].text = "$result"
        for (i in 0..4) {
            if (i == r)
                group[i].text = "$result"
        }
    }


    fun onclick(it: View) {
        if (count == numberOfQuestion) {
            intent = Intent(this, winner::class.java)
            startActivity(intent)
        } else {
            val button = it as Button
            val pressedButton = button.text.toString().toInt()
            if (pressedButton == result) {
                Toast.makeText(this, "Верно", Toast.LENGTH_SHORT).show()
                count++
                tvCount.text = "Уровень : $count"
            } else {
                Toast.makeText(this, "Не Верно", Toast.LENGTH_SHORT).show()
                intent = Intent(this, loser::class.java)
                startActivity(intent)
            }

            game()
        }
    }

}


