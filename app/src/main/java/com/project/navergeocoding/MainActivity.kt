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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://naveropenapi.apigw.ntruss.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val gecodeAPI = retrofit.create(GeocodeAPI::class.java)

        gecodeAPI.getAddress("TODO 주소 입력","TODO Client ID", "TODO Client Secret")
            .enqueue(object: Callback<GeocodeDTO> {
                override fun onResponse(call: Call<GeocodeDTO>, response: Response<GeocodeDTO>) {
                    if(response.isSuccessful.not()) {
                        return
                    }
                    response.body()?.let {
                        val result = response.body()
                        address_Result.text = result.toString()
                    }
                }
                override fun onFailure(call: Call<GeocodeDTO>, t: Throwable) {
                    Log.d("Fail", "실패")
                }

            })
    }
}