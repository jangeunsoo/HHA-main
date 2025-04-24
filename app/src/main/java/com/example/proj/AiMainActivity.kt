package com.example.proj

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AiMainActivity : AppCompatActivity()  {

    lateinit var btn_home: ImageButton
    lateinit var btn_my: Button
    lateinit var btn_search: ImageButton
    lateinit var btn_ai: Button
    lateinit var btn_result: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hha_ai_main)
        
        btn_home = findViewById(R.id.btn_home)
        btn_my = findViewById(R.id.btn_my)
        btn_ai = findViewById(R.id.btn_ai)
        btn_search = findViewById(R.id.btn_search)
        btn_result = findViewById(R.id.btn_result)

        val intent = Intent(this, SubActivity::class.java)
        startActivity(intent)

        btn_home.setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

        btn_ai.setOnClickListener {
            val it = Intent(this, AiMainActivity::class.java)
            startActivity(it)
        }

        btn_my.setOnClickListener {
            startActivity(Intent(this, ClientFirstActivity::class.java))
        }

        btn_search.setOnClickListener {
            startActivity(Intent(this, SearchMainActivity::class.java))
        }

        btn_result.setOnClickListener {
            startActivity(Intent(this, AiResultActivity::class.java))
        }

    }
}