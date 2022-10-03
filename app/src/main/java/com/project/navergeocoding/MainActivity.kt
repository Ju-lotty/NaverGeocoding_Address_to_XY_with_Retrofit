package com.project.navergeocoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.project.navergeocoding.gecodeapi.GeocodeAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val address_Result: TextView by lazy {
        findViewById(R.id.address_Result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //빌더 패턴을 통해 baseUrl과 json 변환 추가
        val retrofit = Retrofit.Builder()
            .baseUrl("https://naveropenapi.apigw.ntruss.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //변수 geocodeAPI의 인터페이스 추가
        val gecodeAPI = retrofit.create(GeocodeAPI::class.java)

        gecodeAPI.getAddress("TODO 원하는 주소 입력","TODO 클라이언트 ID 값","TODO 클라이언트 API 값")
            .enqueue(object: Callback<GeocodeDTO> {
                override fun onResponse(call: Call<GeocodeDTO>, response: Response<GeocodeDTO>) {
                    //실패 시 리턴
                    if(response.isSuccessful.not()) {
                        return
                    }
                    //response 즉, 결과 값이 널이 아니라면 출력
                    response.body()?.let {
                        val result = response.body()
                        address_Result.text = result.toString()
                    }
                }

                override fun onFailure(call: Call<GeocodeDTO>, t: Throwable) {
                    Log.d("TAG", "실패")
                }

            })
    }
}