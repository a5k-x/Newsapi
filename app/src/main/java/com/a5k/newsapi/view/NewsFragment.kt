package com.a5k.newsapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a5k.newsapi.data.model.NewsItem
import com.a5k.newsapi.databinding.FragmentNewsBinding
import com.a5k.newsapi.view.adapter.ClickHandler
import com.a5k.newsapi.view.adapter.MainAdapter
import com.a5k.newsapi.viewModel.MainViewModel

class NewsFragment : Fragment() {

    private var vb: FragmentNewsBinding? = null
    private var mainAdapter = MainAdapter()
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentNewsBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        viewModel.getLiveData().observe(viewLifecycleOwner) { data -> render(data) }
        viewModel.getDataListNews()
    }

    private fun render(data: AppState?) {
        when (data) {
            is AppState.Success -> {
                mainAdapter.init(data.listNews.articles)
            }
            is AppState.Loading -> {
                Toast.makeText(requireContext(), LOADING, Toast.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                Toast.makeText(requireContext(), ERROR_LOAD, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initAdapter() {
        mainAdapter.initListenerItem(object : ClickHandler {
            override fun clickListener(news: NewsItem) {
                (activity as IViewTitle).toItemNews(news)
            }
        })

        vb?.recyclerContainerNews?.run {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = mainAdapter
        }
    }
    override fun onResume() {
        super.onResume()
        (activity as IViewTitle).run {
            setHomeUp(false)
            setTitle(TITLE)
        }
    }
    companion object{
        private const val TITLE = "News"
        private const val LOADING = "Loading"
        private const val ERROR_LOAD = "error loading"

    }
}