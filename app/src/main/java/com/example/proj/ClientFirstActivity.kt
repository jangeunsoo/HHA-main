package com.example.proj

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ClientFirstActivity : AppCompatActivity() {

    lateinit var my_register_btn: Button
    lateinit var my_login_btn: Button
    lateinit var btn_home: ImageButton
    lateinit var btn_my: Button
    lateinit var btn_search: ImageButton
    lateinit var btn_ai: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hha_client_first)
        //my_register_btn = findViewById(R.id.my_register_btn)
        //my_login_btn = findViewById(R.id.my_login_btn)
        btn_home = findViewById(R.id.btn_home)
        btn_my = findViewById(R.id.btn_my)
        btn_ai = findViewById(R.id.btn_ai)
        btn_search = findViewById(R.id.btn_search)

        btn_home.setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

        btn_ai.setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

        my_login_btn.setOnClickListener {
            val it = Intent(this, LoginActivity::class.java)
            startActivity(it)
        }

        my_register_btn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_my.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btn_search.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}