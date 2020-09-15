package com.example.articlesapp.model

import com.google.gson.annotations.Expose


data class MediaModel(

    @Expose
    val id: String,

    @Expose
    val blogId: String,

    @Expose
    val createdAt: String,

    @Expose
    val image: String,

    @Expose
    val title: String,

    @Expose
    val url: String
)