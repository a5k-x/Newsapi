package com.a5k.newsapi.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a5k.newsapi.data.model.Articles
import com.a5k.newsapi.databinding.ItemNewsBinding

class MainAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listNews = listOf<Articles>()

    fun init(listNews:List<Articles>){
        this.listNews = listNews
    }

    inner class ViewHolder(private val vb: ItemNewsBinding) :RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            vb?.titleNews.text = listNews[position].title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
       return ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount()= listNews.size
}