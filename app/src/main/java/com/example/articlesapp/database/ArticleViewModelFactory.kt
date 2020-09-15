package com.example.articlesapp.database

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.articlesapp.viewmodel.ArticleViewModel

class ArticleViewModelFactory(private var application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ArticleViewModel::class.java)){
            return ArticleViewModel(application) as T
        } else {
            return modelClass as T
        }

    }

}

