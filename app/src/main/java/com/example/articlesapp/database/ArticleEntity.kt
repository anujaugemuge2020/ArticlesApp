package com.example.articlesapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_table")
class ArticleEntity(
    @field:PrimaryKey (autoGenerate = false)
    var id: Int,
    @ColumnInfo(name = "createdAt")
    var createdAt: String,
    @ColumnInfo(name = "content")
    var content: String,
    @ColumnInfo(name = "comments")
    var comments: Long,
    @ColumnInfo(name = "likes")
    var likes: Long,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "designation")
    var designation: String,
    @ColumnInfo(name = "url")
    var url: String,
    @ColumnInfo(name = "articleUrl")
    var articleUrl: String,
    @ColumnInfo(name = "userUrl")
    var userUrl: String,
    @ColumnInfo(name = "title")
    var title: String


)