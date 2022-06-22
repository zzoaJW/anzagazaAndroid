package com.z0o0a.anzagaza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.z0o0a.anzagaza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ActivityMainDialogInterface {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.activityMainRouteMap.setImageResource(R.drawable.route_map_220623)

        binding.activityMainOverlayout.setVisibility(View.VISIBLE)

        binding.activityMainOverlayoutX.setOnClickListener {
            binding.activityMainOverlayout.setVisibility(View.GONE)
        }

        // 지하철 탑승 빨간 동그라미 처리 if문

        binding.activityMainBtnEndSearchbar.setOnClickListener {
            intent = Intent(this, SearchStation::class.java)
            startActivity(intent)
        }

        binding.activityMainBtnStartSearchbar.setOnClickListener {
            intent = Intent(this, SearchStation::class.java)
            startActivity(intent)
        }

        binding.activityMainBtnSub.setOnClickListener {
            intent = Intent(this, CurrentBoarding::class.java)
            startActivity(intent)
        }

        binding.activityMainFloatingbtn.setOnClickListener {
            startDialog()
        }



    }

    private fun startDialog(){
        val dialog = ActivityMainDialog()

        // 알림창이 띄워져있는 동안 배경 클릭 막기
        dialog.isCancelable = false
        dialog.show(this.supportFragmentManager, "ActivityMainDialog")
    }

    override fun selectRecentRoute(){
        intent = Intent(this, CompleteBoarding::class.java)
        startActivity(intent)

    }
}