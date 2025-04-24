package com.example.proj

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class SubActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var button: Button? = null
    var TAG = "SubActivity"

    private lateinit var getContent: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hha_ai_main)
        imageView = findViewById(R.id.img_input)
        button = findViewById(R.id.btn_input)
        getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                // 선택된 이미지가 있을 경우 ImageView에 설정
                imageView?.setImageURI(uri)
            }

        }

        button?.setOnClickListener {
            // 갤러리로 이동하는 Intent를 실행
            getContent.launch("image/*")
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == RESULT_OK) {
                val uri = data!!.data
                imageView!!.setImageURI(uri)
            }

        }
        finish()
    }

}