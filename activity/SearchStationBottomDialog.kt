package com.z0o0a.anzagaza

import android.graphics.Color
import android.graphics.Insets.add
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.z0o0a.anzagaza.databinding.SearchStationBottomDialogBinding

class SearchStationBottomDialog() : BottomSheetDialogFragment(){

    private var _binding: SearchStationBottomDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var searchStationBottomDialogHosunAdapter: SearchStationBottomDialogHosunAdapter
    val datas = mutableListOf<SearchStationBottomDialogHosunData>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreate(savedInstanceState)
        _binding = SearchStationBottomDialogBinding.inflate(inflater, container, false)
        val view = binding.root

        initRecycler()

        // 레이아웃 배경을 투명하게 해줌, 필수 아님
        // dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.searchStationBottomDialogX.setOnClickListener {
            dismiss()
        }

        return view
    }

    companion object {
        const val TAG = "SearchStationBottomDialog"
    }

    private fun initRecycler() {
        searchStationBottomDialogHosunAdapter = SearchStationBottomDialogHosunAdapter(requireContext())
        binding.searchStationBottomDialogHosunRecyclerview.adapter = searchStationBottomDialogHosunAdapter


        datas.apply {
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_1, hosun_txt = "1호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_2, hosun_txt = "2호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_3, hosun_txt = "3호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_4, hosun_txt = "4호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_5, hosun_txt = "5호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_6, hosun_txt = "6호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_7, hosun_txt = "7호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_8, hosun_txt = "8호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_9, hosun_txt = "9호선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_sb, hosun_txt = "수인분당선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_gc, hosun_txt = "경의중앙선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_gongc, hosun_txt = "공항철도"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_kj, hosun_txt = "경춘선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_sinb, hosun_txt = "신분당선"))
            add(SearchStationBottomDialogHosunData(hosun_img = R.drawable.circle_line_us, hosun_txt = "우이신설선"))

            searchStationBottomDialogHosunAdapter.datas = datas
            searchStationBottomDialogHosunAdapter.notifyDataSetChanged()

        }
    }



}