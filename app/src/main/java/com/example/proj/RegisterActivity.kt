package com.example.proj

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
//import com.example.proj.data.BackUtil

class RegisterActivity: AppCompatActivity() {
    lateinit var btn_home: ImageButton
    lateinit var btn_my: Button
    lateinit var btn_ai: Button
    lateinit var btn_search: ImageButton
    lateinit var btn_basket: ImageButton
    lateinit var btn_complete: Button
    lateinit var et_id: EditText
    lateinit var et_pw: EditText
    lateinit var et_name: EditText
    lateinit var et_phone: EditText

//    val backUtil = BackUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.hha_register)

        btn_home = findViewById(R.id.btn_home)
        btn_my = findViewById(R.id.btn_my)
        btn_ai = findViewById(R.id.btn_ai)
        btn_search = findViewById(R.id.btn_search)
        btn_basket = findViewById(R.id.btn_basket)
//        btn_complete = findViewById(R.id.btn_complete)
//
//        et_id = findViewById(R.id.et_id)
//        et_pw = findViewById(R.id.et_pw)
//        et_name = findViewById(R.id.et_name)
//        et_phone = findViewById(R.id.et_phone)

        btn_home.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

//        btn_complete.setOnClickListener {
//            backUtil.register(et(et_id), et(et_pw), et(et_name), et(et_phone))
//        }

    }

    fun et(et: EditText): String {
        return et.text.toString()
    }
}