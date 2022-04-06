package com.a5k.newsapi.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.a5k.newsapi.data.model.Articles
import com.a5k.newsapi.databinding.ItemNewsBinding

class MainAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listNews = listOf<Articles>()
    lateinit var clickHandler: ClickHandler

    fun initListenerItem(listener:ClickHandler){
        this.clickHandler = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun init(listNews:List<Articles>){
        this.listNews = listNews
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val vb: ItemNewsBinding) :RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            vb?.titleNews.text = listNews[position].title
            itemView.setOnClickListener {
                clickHandler.clickListener(listNews[position])
            }
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

interface ClickHandler{
    fun clickListener(articles: Articles)
}