package com.example.proj

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.proj.data.BackUtil

class LoginActivity : AppCompatActivity() {

    lateinit var loginidtext: EditText
    lateinit var passwordtext: EditText
    lateinit var loginBtn: Button
    lateinit var homeBtn: ImageButton
    lateinit var regBtn: Button
    lateinit var btn_ai: Button
    //val backUtil = BackUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.hha_login)
//        homeBtn = findViewById(R.id.btn_home)
//        loginidtext = findViewById(R.id.loginid_text)
//        passwordtext = findViewById(R.id.password_text)
//        loginBtn = findViewById(R.id.btn_login)
//        regBtn = findViewById(R.id.btn_reg)
        btn_ai = findViewById(R.id.btn_ai)

        homeBtn.setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

        btn_ai.setOnClickListener {
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }


//        loginBtn.setOnClickListener {
//            var email = loginidtext.text.toString()
//            var password = passwordtext.text.toString()
//
//            backUtil.login(email, password)
//        }

        regBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }

//    fun login(){
//        setContentView(R.layout.hha_login)
//
//        val btn_home = findViewById<ImageButton>(R.id.btn_home)
//        val btn_my: Button = findViewById(R.id.btn_my)
//        val btn_ai: Button = findViewById(R.id.btn_ai)
//        val btn_search = findViewById<ImageButton>(R.id.btn_search)
//        val btn_basket = findViewById<ImageButton>(R.id.btn_basket)
//        val btn_reg: Button = findViewById(R.id.btn_reg)
//        val btn_login: Button = findViewById(R.id.btn_login)
//
//        btn_home.setOnClickListener{
//            start()
//        }
//        btn_ai.setOnClickListener{
//            ai()
//        }
//        btn_my.setOnClickListener{
//            my()
//        }
//        btn_search.setOnClickListener{
//            search()
//        }
//        btn_basket.setOnClickListener{
//            basket()
//        }
//        btn_reg.setOnClickListener{
//            register()
//        }
//    }
}

