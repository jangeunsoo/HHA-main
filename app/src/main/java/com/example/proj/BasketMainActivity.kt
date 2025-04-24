package com.example.proj

import android.os.Bundle
import android.content.Intent
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class BasketMainActivity : AppCompatActivity() {

    lateinit var btn_back2: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hha_basket_main)

        btn_back2 = findViewById(R.id.btn_back2)
        btn_back2 .setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

    }
}