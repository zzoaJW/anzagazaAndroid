package com.z0o0a.anzagaza

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.CurrentBoardingBinding

class CurrentBoarding : AppCompatActivity() {
    private lateinit var binding: CurrentBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CurrentBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            intent = Intent(this, TransferCheck::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            intent = Intent(this, CompleteBoarding::class.java)
            startActivity(intent)
        }




    }

}