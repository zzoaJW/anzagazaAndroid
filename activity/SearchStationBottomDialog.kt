package com.z0o0a.anzagaza

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.z0o0a.anzagaza.databinding.SearchStationBottomDialogBinding

class SearchStationBottomDialog() : BottomSheetDialogFragment(){

    private var _binding: SearchStationBottomDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        _binding = SearchStationBottomDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        // 레이아웃 배경을 투명하게 해줌, 필수 아님
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.searchStationBottomDialogX.setOnClickListener {
            dismiss()
        }

        return view
    }

    companion object {
        const val TAG = "SearchStationBottomDialog"
    }

}