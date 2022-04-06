package com.a5k.newsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.a5k.newsapi.R
import com.a5k.newsapi.data.model.NewsItem
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity(),IViewTitle {

    private lateinit var navigation: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = Navigation.findNavController(this, R.id.fragment_container)
        val tool = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(tool)
        setHomeUp(false)
    }

    override fun onSupportNavigateUp(): Boolean {
        navigation.popBackStack()
        return true
    }

   override fun toItemNews(news: NewsItem) {
        val bundle = Bundle()
        bundle.putParcelable(KEY_NEWS, news)
        navigation.navigate(R.id.action_newsFragment_to_itemNewsFragment,bundle)
    }

    override fun setHomeUp(flag: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(flag)
    }
    override fun setTitle(title: String) {
        supportActionBar?.title = title
    }

    companion object{
        private const val KEY_NEWS = "news"
    }

}