package com.z0o0a.anzagaza

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.TransferCheckBinding

class TransferCheck : AppCompatActivity() {
    private lateinit var binding: TransferCheckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TransferCheckBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

}