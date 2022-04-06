package com.a5k.newsapi.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.RoundedCornersTransformation
import com.a5k.newsapi.data.model.NewsItem
import com.a5k.newsapi.databinding.FragmentItemNewsBinding


class ItemNewsFragment : Fragment() {
    private var news: NewsItem? = null
    private var vb: FragmentItemNewsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        news = arguments?.get(KEY_NEWS) as NewsItem?
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentItemNewsBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initContext()
    }

    private fun initContext() {
        vb?.titleArticle?.text = news?.title
        vb?.imageArticle?.load(news?.urlToImage) {
            transformations(RoundedCornersTransformation(30f))
        }
        vb?.articleDescription?.text = news?.description
        vb?.openArticle?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, news?.url?.toUri())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as IViewTitle).run {
            setHomeUp(true)
            setTitle(news?.author.toString())
        }
    }

    companion object {
        private const val KEY_NEWS = "news"
    }
}