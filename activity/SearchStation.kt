package com.z0o0a.anzagaza

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.SearchStationBinding

class SearchStation : AppCompatActivity() {
    private lateinit var binding: SearchStationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchStationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.searchStationBtnBack.setOnClickListener {
            finish()
        }

        setListenerToEditText()

    }

    private fun setListenerToEditText() {
        binding.searchStationEdittext.setOnKeyListener { view, keyCode, event ->
            // Enter Key Action
            if (event.action == KeyEvent.ACTION_DOWN
                && keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                // 키패드 내리기
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.searchStationEdittext.windowToken, 0)
                true
            }

            false
        }
    }
}