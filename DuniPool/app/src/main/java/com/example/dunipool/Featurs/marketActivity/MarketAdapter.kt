package com.example.dunipool.Featurs.marketActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dunipool.ApiManager.IMAGE_BASE_URL
import com.example.dunipool.ApiManager.module.CoinsData
import com.example.dunipool.databinding.ItemCoinBinding

class MarketAdapter(
    private val data: List<CoinsData.Data> ,
    ) : RecyclerView.Adapter<MarketAdapter.ViewHolder>() {

    lateinit var binding: ItemCoinBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind ( item:CoinsData.Data ){
            // here we initialize the views with the information of coinsData
            binding.txtCoinName.text = item.coinInfo.name
            binding.txtCoinPrice.text = item.rAW.uSD.pRICE.toString()
            binding.txtMarketCap.text = item.rAW.uSD.mKTCAP.toString()
            binding.txtCoinChanges.text = item.rAW.uSD.cHANGEPCT24HOUR.toString()

            Glide.with(itemView)
                .load(IMAGE_BASE_URL + item.rAW.uSD.iMAGEURL)
                .into(binding.imgCoinPhoto)


        }
    }

    // initializing binding in first function
    // item view = binding.root
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemCoinBinding.inflate(inflater)

        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int = data.size

    // here we just use bind function
    override fun onBindViewHolder(holder: ViewHolder, position: Int) { ViewHolder(binding.root).bind(data[position]) }



}