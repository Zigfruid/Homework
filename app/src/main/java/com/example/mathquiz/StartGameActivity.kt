package com.example.mathquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start_game.*
import kotlin.random.Random


class StartGameActivity : AppCompatActivity() {
    var res = 0
    var count = 0
    private val numberOfQuestion = 10


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
        res = when (c) {
            1 -> a + b
            2 -> a - b
            3 -> a * b
            else -> a / b
        }
        val d = Random.nextInt(5, 50) + res
        val e = Random.nextInt(12, 30) + res
        val f = Random.nextInt(8, 100) + res
        val j = Random.nextInt(1, 10) + res

        val r = Random.nextInt(0, 4)
        val group = arrayListOf<Button>(btn1, btn3, btn3, btn4)
        btn1.text = "$d"
        btn2.text = "$e"
        btn3.text = "$f"
        btn4.text = "$j"
        group[r].text = "$res"
        for (i in 0..4) {
            if (i == r)
                group[i].text = "$res"
        }
    }


    fun onclick(it: View) {
        if (count == numberOfQuestion) {
            intent = Intent(this, winner::class.java)
            startActivity(intent)
        } else {
            val button = it as Button
            val pressedButton = button.text.toString().toInt()
            if (pressedButton == res) {
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


