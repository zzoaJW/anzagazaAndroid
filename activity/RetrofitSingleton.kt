package com.z0o0a.anzagaza

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.concurrent.TimeUnit

object RetrofitSingleton {
    private var instance: Retrofit? = null
    private const val CONNECT_TIMEOUT_SEC = 20000L
    const val BASE_URL = "http://15.165.244.220/"

    var encoding_BASE_URL = URLEncoder.encode(BASE_URL, "UTF-8")
    var decoding_BASE_URL = URLDecoder.decode(encoding_BASE_URL, "ISO-8859-1")

    fun getInstance() : Retrofit {
        if(instance == null){

            // 로깅인터셉터 세팅
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            // OKHttpClient에 로깅인터셉터 등록
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(CONNECT_TIMEOUT_SEC, TimeUnit.SECONDS)
                .build()

            instance = Retrofit.Builder()
                .baseUrl(decoding_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client) // Retrofit 객체에 OkHttpClient 적용
                .build()
        }
        return instance!!
    }
}