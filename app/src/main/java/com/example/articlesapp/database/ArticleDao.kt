package com.example.articlesapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ArticleDao {
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(article: ArticleEntity?)

    @Update
    fun update(article: ArticleEntity?)

    @Delete
    fun delete(article: ArticleEntity?)

    @Query("DELETE FROM article_table")
    fun deleteAllArticles()

    @get:Query("SELECT * FROM article_table ORDER BY id DESC")
    val allArticles: LiveData<List<ArticleEntity?>?>?
}