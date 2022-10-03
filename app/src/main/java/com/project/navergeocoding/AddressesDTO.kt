package com.project.navergeocoding

import com.google.gson.annotations.SerializedName


//addresses 내부에 있는 도로명 주소, 위도, 영문 주소 등 추출하는 공간
data class AddressesDTO(
    @SerializedName("x")val x: String, //경도
    @SerializedName("y")val y: String,  //위도
)
