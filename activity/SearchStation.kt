package com.z0o0a.anzagaza

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.SearchStationBinding

class SearchStation : AppCompatActivity() {
    private lateinit var binding: SearchStationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchStationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 작동 외않되
        // setVisibleClearBtn(binding.searchStationBtnClear, binding.searchStationEdittext)

        binding.searchStationBtnBack.setOnClickListener {
            finish()
        }

        setListenerToEditText()

        binding.searchStationBtnHosun.setOnClickListener {
            val searchStationBottomDialog = SearchStationBottomDialog()
            searchStationBottomDialog.show(supportFragmentManager, searchStationBottomDialog.tag)

        }

        binding.searchStationBtnClear.setOnClickListener {
            editTextClear(binding.searchStationEdittext)
        }

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

    // 손 봐줘야함
    fun setVisibleClearBtn(btn:ImageButton, txt: EditText) {
        if (txt.getText()==null) {
            btn.setVisibility(View.GONE)
        } else {
            btn.setVisibility(View.VISIBLE)
        }
    }

    fun editTextClear(txt: EditText) {
        txt.setText(null)
    }
}