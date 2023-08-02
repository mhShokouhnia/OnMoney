package com.example.dunipool.Featurs.marketActivity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dunipool.ApiManager.ApiManager
import com.example.dunipool.ApiManager.module.CoinsData
import com.example.dunipool.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {

    private val apiManager = ApiManager()
    lateinit var binding: ActivityMarketBinding
    lateinit var newsData: ArrayList<Pair<String, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intiUi()
    }

    private fun intiUi() {
        // NEWS =>
        getNewsFromApi()

        // COINS =>
        getCoinsFromApi()

    }

    // NEWS :
    private fun getNewsFromApi() {

        apiManager.getNews(object : ApiManager.ApiCallback<ArrayList<Pair<String, String>>> {
            override fun onSuccess(data: ArrayList<Pair<String, String>>) {
                newsData = data
                refreshNews()
            }

            override fun onError(message: String) {
                Toast.makeText(this@MarketActivity, "error => $message", Toast.LENGTH_SHORT).show()
            }

        })
    }
    fun refreshNews() {

        val randomNumber = (1..49).random()
        binding.moduleNews.txtNews.text = newsData[randomNumber].first
        binding.moduleNews.txtNews.setOnClickListener { refreshNews() }

        binding.moduleNews.imgNews.setOnClickListener {
            val intent: Intent =
                Intent(Intent.ACTION_VIEW, Uri.parse(newsData[randomNumber].second))
            startActivity(intent)
        }

    }

    // COINS :
    private fun getCoinsFromApi() {
        apiManager.getTopCoins(object : ApiManager.ApiCallback<List<CoinsData.Data>> {
            override fun onSuccess(data: List<CoinsData.Data>) {
                showCoins(data)
            }

            override fun onError(message: String) {
                Log.v("hamidError", message)
            }

        })
    }
    private fun showCoins(data: List<CoinsData.Data>) {

        val marketAdapter = MarketAdapter(data)
        binding.moduleWatchlist.rcyMarket.adapter = marketAdapter
        binding.moduleWatchlist.rcyMarket.layoutManager = LinearLayoutManager(this)

    }



}