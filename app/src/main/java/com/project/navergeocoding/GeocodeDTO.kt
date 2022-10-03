package com.project.navergeocoding

import com.google.gson.annotations.SerializedName

data class GeocodeDTO(
    //@SerializedName Postman의 결과 파라미터 값을 매칭
    //응답 바디
    @SerializedName("status")val status: String, //검색 결과 상태 코드, 필수여부 Y
    @SerializedName("addresses[].roadAddress")val roadAddress: String, //도로명주소
    @SerializedName("addresses[].x")val x: String, //경도
    @SerializedName("addresses[].y")val y: String,  //위도
    @SerializedName("errorMessage")val errorMessage: String //에러 메시지
)
