package com.example.articlesapp.model

import com.google.gson.annotations.Expose


data class UserModel(

    @Expose
    val id: String,
    @Expose
    val blogId: String,
    @Expose
    val createdAt: String,
    @Expose
    val name: String,
    @Expose
    val avatar: String,
    @Expose
    val city: String,
    @Expose
    val designation: String,
    @Expose
    val about: String
)