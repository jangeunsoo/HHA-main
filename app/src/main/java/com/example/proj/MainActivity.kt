package com.example.proj

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    // btn_search 변수 선언
    private lateinit var btn_search: ImageButton

    // start 함수
    private fun start() {
        setContentView(R.layout.hha_main)
        val btn_ai: Button = findViewById(R.id.btn_ai)
        val btn_my: Button = findViewById(R.id.btn_my)
        btn_search = findViewById(R.id.btn_search) // btn_search 초기화
        val btn_basket: ImageButton = findViewById(R.id.btn_basket) // btn_basket의 타입을 ImageButton으로 선언

        // 각 버튼에 대한 클릭 리스너 설정
        btn_ai.setOnClickListener {
            val intent = Intent(this, AiMainActivity::class.java)
            startActivity(intent)
        }
        btn_my.setOnClickListener {
            val intent = Intent(this, ClientFirstActivity::class.java)
            startActivity(intent)
        }
        btn_search.setOnClickListener {
            val intent = Intent(this, SearchMainActivity::class.java)
            startActivity(intent)
        }
        btn_basket.setOnClickListener {
            val intent = Intent(this, BasketMainActivity::class.java)
            startActivity(intent)
        }
    }

    // onCreate 메소드
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        start()
    }
}
