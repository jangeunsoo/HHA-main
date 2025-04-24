package com.example.proj

import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class SearchMainActivity : AppCompatActivity() {

    lateinit var btn_back: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hha_search_main)

        btn_back = findViewById(R.id.btn_back)
        btn_back .setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

    }
}