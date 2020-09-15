package com.example.articlesapp.network

import com.example.articlesapp.model.ArticleModel
import retrofit2.Call
import retrofit2.http.GET

interface ArticleApiInterface {

    @GET("blogs?page=1&limit=10")
    fun getArticles(): Call<List<ArticleModel>>

}
