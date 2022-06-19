package com.z0o0a.anzagaza

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.z0o0a.anzagaza.databinding.ActivityMainDialogBinding

class ActivityMainDialog () : DialogFragment() {

    private var _binding: ActivityMainDialogBinding? = null
    private val binding get() = _binding!!

    private var activityMainDialogInterface: ActivityMainDialogInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        // 레이아웃 배경을 투명하게 해줌, 필수 아님
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // 추가 버튼 클릭 시 onAddButtonClicked 호출 후 종료
        binding.activityMainDialogBtnX.setOnClickListener {
            dismiss()}

        // 취소 버튼 클릭 시 onCancelButtonClicked 호출 후 종료
        binding.activityMainDialogBtnSelect.setOnClickListener {
            activityMainDialogInterface?.selectRecentRoute()
            dismiss()}

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}