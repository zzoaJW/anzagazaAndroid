package com.z0o0a.anzagaza

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.z0o0a.anzagaza.databinding.SearchStationBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SearchStation : AppCompatActivity() {
    private lateinit var binding: SearchStationBinding

    private val retrofit: Retrofit = RetrofitSingleton.getInstance() // RetrofitClient의 instance 불러오기
    private val api: AnzaAPI = retrofit.create(AnzaAPI::class.java) // retrofit이 interface 구현

    private lateinit var searchStationResultsAdapter: SearchStationResultsAdapter
    val datas = mutableListOf<SearchStationResultsData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchStationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 이거 검색 결과 recyclerview인데 작동이 안된다...
        initResultsRecycler()

        // 왜 안없어짐;;
        setVisibleClearBtn(binding.searchStationBtnClear, binding.searchStationEdittext)

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


        // Retrofit 통신
        Runnable {
            api.getRouteStations("7호선").enqueue(object : Callback<RouteStationsResponse> {
                // 전송 실패
                override fun onFailure(call: Call<RouteStationsResponse>, t: Throwable) {
                    Log.d("태그", t.message!!)
                    Log.d("태그", "실패했음")
                }
                // 전송 성공
                override fun onResponse(call: Call<RouteStationsResponse>, response: Response<RouteStationsResponse>) {
                    Log.d("태그", "response : ${response.body()?.routeStations}") // 정상출력

                    // 전송은 성공 but 서버 4xx 에러
                    Log.d("태그: 에러바디", "response : ${response.errorBody()}")
                    Log.d("태그: 메시지", "response : ${response.message()}")
                    Log.d("태그: 코드", "response : ${response.code()}")

                    Log.d("태그", "성공했음")


                    // 검색 예시 - "공릉" 있는지 없는지 확인 (이거 보고 한 다음, 이건 지우기)
/*
                    for(i: Int in 0..response.body()?.routeStations!!.size){
                        if (response.body()?.routeStations?.get(i)?.stationName.toString()=="공릉"){
                            binding.searchStationTestTxt.setText("공릉있음")
                            binding.searchStationTestTxt2.setText(response.body()?.routeStations?.get(i)?.route.toString())
                            break
                        }
                    }
*/



                    // 텍스트 넣기 예시 (이거 보고 한 다음, 이건 지우기)
                    // binding.routeStationsList.setText(response.body()?.routeStations.toString())
                    // binding.routeStationsName1.setText(response.body()?.routeStations?.get(0)?.stationName.toString())
                    // binding.routeStationsRoute1.setText(response.body()?.routeStations?.get(0)?.route.toString())
                }
            })
        }.run()

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

    private fun initResultsRecycler() {
        searchStationResultsAdapter = SearchStationResultsAdapter(this)
        binding.searchStationRecyclerview.adapter = searchStationResultsAdapter


        datas.apply {
            add(SearchStationResultsData(hosun_img = R.drawable.circle_line_1, hosun_txt = "1호선"))
/*
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
*/

            searchStationResultsAdapter.datas = datas
            searchStationResultsAdapter.notifyDataSetChanged()

        }
    }
}