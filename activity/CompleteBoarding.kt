package com.z0o0a.anzagaza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.CompleteBoardingBinding

class CompleteBoarding : AppCompatActivity() {
    private lateinit var binding: CompleteBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CompleteBoardingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

}