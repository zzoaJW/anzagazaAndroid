package com.z0o0a.anzagaza

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SearchStationBottomDialogHosunAdapter(private val context: Context) : RecyclerView.Adapter<SearchStationBottomDialogHosunAdapter.ViewHolder>() {

    var datas = mutableListOf<SearchStationBottomDialogHosunData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_search_station_bottom_dialog_hosun,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val hosunImg: ImageView = itemView.findViewById(R.id.item_search_station_bottom_dialog_item_hosun_img)
        private val hosunTxt: TextView = itemView.findViewById(R.id.item_search_station_bottom_dialog_hosun_line_txt)

        fun bind(item: SearchStationBottomDialogHosunData) {
            Glide.with(itemView).load(item.hosun_img).into(hosunImg)
            hosunTxt.text = item.hosun_txt.toString()
        }
    }


}