package com.a5k.newsapi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a5k.newsapi.R
import com.a5k.newsapi.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var vb:FragmentNewsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentNewsBinding.inflate(inflater,container,false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}