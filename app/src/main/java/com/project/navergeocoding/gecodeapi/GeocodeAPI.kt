package com.project.navergeocoding.gecodeapi

import com.project.navergeocoding.GeocodeDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface GeocodeAPI {
    @GET("/map-geocode/v2/geocode") //Base url을 제외한 주소
    fun getAddress(
        @Query("query") query: String, //사용자가 입력할 주소, 요청 파라미터 필수여부 Y
        @Header("X-NCP-APIGW-API-KEY-ID") clientId: String, //필수 요청 헤더값 ID, API KEY
        @Header("X-NCP-APIGW-API-KEY") clientSecret: String //요청 헤더 필수여부 Y
    ): Call<GeocodeDTO> // TODO: 반환형은 모델 데이터
}