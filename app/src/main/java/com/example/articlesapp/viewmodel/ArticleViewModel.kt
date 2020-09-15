package com.example.articlesapp.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.articlesapp.database.ArticleDatabase
import com.example.articlesapp.database.ArticleEntity
import com.example.articlesapp.database.ArticleRepository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticleViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ArticleRepository
    val allArticles: LiveData<List<ArticleEntity?>?>?

    init {
        val articleDao = ArticleDatabase.getDatabase(application).articleDao()
        repository = ArticleRepository(articleDao!!)
        allArticles = repository.allArticles
    }



    fun insert(word: ArticleEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

    fun getAll(): LiveData<List<ArticleEntity?>?>?  {
        return repository.allArticles
    }

    fun deleteAll() = viewModelScope.launch(Dispatchers.IO) {
         repository.deleteAllArticles()
    }
}