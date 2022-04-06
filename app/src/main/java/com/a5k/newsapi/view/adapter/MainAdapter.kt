package com.a5k.newsapi.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.a5k.newsapi.R
import com.a5k.newsapi.data.model.NewsItem
import com.a5k.newsapi.databinding.ItemNewsBinding

class MainAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listNews = listOf<NewsItem>()
    lateinit var clickHandler: ClickHandler

    fun initListenerItem(listener:ClickHandler){
        this.clickHandler = listener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun init(listNews:List<NewsItem>){
        this.listNews = listNews
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val vb: ItemNewsBinding) :RecyclerView.ViewHolder(vb.root) {
        fun bind(position: Int) {
            vb?.titleText.text = listNews[position].title
            vb?.moreText.setOnClickListener {
                clickHandler.clickListener(listNews[position])
            }
            vb?.authorText.text = listNews[position].author
            val imageLoader = ImageLoader.Builder(vb.root.context)
                .error(R.drawable.icon_error)
                .placeholder(R.drawable.icon_download_image)
                .build()
            vb?.cardImageView.load(listNews[position].urlToImage,imageLoader){transformations(
                RoundedCornersTransformation(20F)
            )}

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
    fun clickListener(news: NewsItem)
}