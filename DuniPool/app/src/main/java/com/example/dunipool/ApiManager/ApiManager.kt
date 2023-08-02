package com.example.dunipool.ApiManager

import com.example.dunipool.ApiManager.module.CoinsData
import com.example.dunipool.ApiManager.module.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    private val apiService: ApiService

    init {

        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)

    }

    // News
    fun getNews(apiCallback: ApiCallback<ArrayList<Pair<String, String>>>) {

        // Send req -> for sending request we need Call Class
        val call: Call<NewsData> = apiService.getNews("popular")

        // Call<what we put here is what we want to send to server>
        // Getting the response by using enqueue function
        call.enqueue(object : Callback<NewsData> {

            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {

                val data = response.body()!!.data
                val newsToSend: ArrayList<Pair<String, String>> = arrayListOf()

                // in forEach we have a variable named it that indicates the current
                data.forEach {
                    newsToSend.add(Pair(it.title, it.url))
                }

                apiCallback.onSuccess(newsToSend)
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                apiCallback.onError(t.message.toString())
            }
        })

    }

    // Coins
    fun getTopCoins(apiCallback: ApiCallback<List<CoinsData.Data>>) {

        apiService.getCoins().enqueue(object : Callback<CoinsData> {
            override fun onResponse(call: Call<CoinsData>, response: Response<CoinsData>) {

                val response = response.body()!!
                apiCallback.onSuccess(response.data)

            }

            override fun onFailure(call: Call<CoinsData>, t: Throwable) {
                apiCallback.onError(t.message.toString())
            }

        })

    }

    // transfer the data to MarketActivity --> apiCallback
    interface ApiCallback<T> {

        fun onSuccess(data: T)
        fun onError(message: String)

    }

}
