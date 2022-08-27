package com.qtnkm.ligalawak.network

import retrofit2.Call
import retrofit2.http.GET

interface Api {

    //api/v1/json/2/all_sports.php
    @GET("all_sports.php")
    fun getSportsFromAPI(): Call<ApiResponse>

}