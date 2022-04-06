package com.a5k.newsapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a5k.newsapi.R
import com.a5k.newsapi.data.model.Articles
import com.a5k.newsapi.databinding.FragmentNewsBinding
import com.a5k.newsapi.view.adapter.ClickHandler
import com.a5k.newsapi.view.adapter.MainAdapter
import com.a5k.newsapi.viewModel.MainViewModel

class NewsFragment : Fragment() {

    private var vb:FragmentNewsBinding?=null
    private var mainAdapter = MainAdapter()
    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentNewsBinding.inflate(inflater,container,false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
    }

    private fun initAdapter() {
      mainAdapter.initListenerItem(object :ClickHandler{
          override fun clickListener(articles: Articles) {
              // открыть страницу статьи
          }
      })

      vb?.recyclerContainerNews?.run {
          layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)
          adapter = mainAdapter
      }
    }

}