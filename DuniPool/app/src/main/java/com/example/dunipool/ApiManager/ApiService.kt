package com.example.dunipool.ApiManager

import com.example.dunipool.ApiManager.module.CoinsData
import com.example.dunipool.ApiManager.module.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {


    // NEWS
    // header is diffrant to headers
    @Headers(API_KEY)
    @GET("v2/news/")
    fun getNews (
        @Query("sortOrder") sortOrder : String = "popular"
    ) : retrofit2.Call<NewsData>

    // COINS
    @Headers(API_KEY)
    @GET("top/totalvolfull")
    fun getCoins(
        @Query("tsym") to_symbol :String = "USD" ,
        @Query("limit") limit_data :Int = 10
    ) : Call<CoinsData>

}