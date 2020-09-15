package com.example.articlesapp.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.articlesapp.R
import com.example.articlesapp.database.ArticleViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_articles.*
import com.example.articlesapp.databinding.ActivityArticlesBinding
import com.example.articlesapp.viewmodel.ArticleViewModel

class ArticlesActivity : AppCompatActivity() {
    lateinit var articleViewModel: ArticleViewModel;
    private var binding: ActivityArticlesBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityArticlesBinding>(this, R.layout.activity_articles)
        var factory = ArticleViewModelFactory(application)
        articleViewModel =  ViewModelProvider(this, factory).get(ArticleViewModel::class.java)
        getData(false)
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            getData(true)

        }

    }

    private fun getData(bool: Boolean) {

        progressbar.visibility = View.GONE
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ArticleAdapter(this@ArticlesActivity)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@ArticlesActivity)

        articleViewModel.allArticles?.observe(this@ArticlesActivity, Observer { words ->
            words?.let { adapter.setWords(it) }
        })
    }


}