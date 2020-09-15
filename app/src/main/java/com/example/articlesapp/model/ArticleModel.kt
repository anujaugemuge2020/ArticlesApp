package com.example.articlesapp.model

import com.google.gson.annotations.Expose


data class ArticleModel(

    @Expose
    val id: Int,
    @Expose
    val createdAt: String,
    @Expose
    val content: String,
    @Expose
    val comments: Long,
    @Expose
    val likes: Long,
    @Expose
    val user: ArrayList<UserModel> = ArrayList(),
    @Expose
    val media: ArrayList<MediaModel> = ArrayList()

)