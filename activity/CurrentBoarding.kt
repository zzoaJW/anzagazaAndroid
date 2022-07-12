package com.z0o0a.anzagaza

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.z0o0a.anzagaza.databinding.CurrentBoardingBinding

class CurrentBoarding : AppCompatActivity() {
    private lateinit var binding: CurrentBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrentBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 구색 맞추려고 임시로 해놓은 것. api 연결 후에는 삭제해야함 (여기서부터)
        binding.currentBoardingLine1.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.line_1))
        binding.currentBoardingLine2.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.line_7))
        binding.currentBoardingImgLineEnd.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.line_7))
        // 구색 맞추려고 임시로 해놓은 것. api 연결 후에는 삭제해야함 (여기까지)

        // radio 처리

        binding.button.setOnClickListener {
            intent = Intent(this, TransferCheck::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            intent = Intent(this, CompleteBoarding::class.java)
            startActivity(intent)
        }

        binding.currentBoardingBack.setOnClickListener {
            finish()
        }






    }

}