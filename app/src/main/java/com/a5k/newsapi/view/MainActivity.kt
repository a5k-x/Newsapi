package com.a5k.newsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.a5k.newsapi.R

class MainActivity : AppCompatActivity() {

    lateinit var navigation: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation = Navigation.findNavController(this, R.id.fragment_container)

    }
}