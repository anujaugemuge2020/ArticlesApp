package com.example.articlesapp.database

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.articlesapp.network.ArticleApiClient
import com.example.articlesapp.model.ArticleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class ArticleRepository(private val articleDao: ArticleDao) {
    var allArticles: LiveData<List<ArticleEntity?>?>? = articleDao.allArticles

    init {
        GlobalScope.launch(Dispatchers.Main) {         getAllArticles()
        }
    }
    suspend fun getAllArticles () {
        if(allArticles === null || allArticles?.value === null) {
            val call: Call<List<ArticleModel>> = ArticleApiClient.getClient.getArticles()
            call.enqueue(object : Callback<List<ArticleModel>> {

                override fun onResponse(
                    call: Call<List<ArticleModel>>?,
                    response: Response<List<ArticleModel>>?
                ) {

                    Log.d("TAG", response?.body().toString())
                    var articles = response?.body()
                    if (articles != null) {
                        for (article in articles) {
                            var article1 = ArticleEntity(
                                article.id,
                                getDuration(article.createdAt),
                                article.content,
                                article.comments,
                                article.likes,
                                article.user[0].name,
                                article.user[0].designation,
                                article.media[0].title,
                                article.media[0].image,
                                article.user[0].avatar,
                                article.media[0].title
                            )
                            GlobalScope.launch(Dispatchers.IO) {
                                articleDao.insert(article1)
                            }
                        }
                        allArticles = articleDao.allArticles
                    }


                }

                override fun onFailure(call: Call<List<ArticleModel>>?, t: Throwable?) {
                }

            })
        }
    }
    suspend fun insert(articleEntity: ArticleEntity) {
        articleDao.insert(articleEntity)
    }

    suspend fun deleteAllArticles() {
        articleDao.deleteAllArticles()
    }

    fun getDuration (date : String) : String {
        val currentDate: Long = System.currentTimeMillis()
        val createdDate: Date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(date)
        val diff: Long = currentDate - createdDate.getTime()
        val diffSeconds = diff / 1000 % 60
        val diffMinutes = diff / (60 * 1000) % 60
        val diffHours = diff / (60 * 60 * 1000)
        val diffInDays = ((currentDate - createdDate.getTime()) / (1000 * 60 * 60 * 24))

        if (diffInDays >= 1) {
            System.err.println("Difference in number of days (2) : $diffInDays")
            return ((diffInDays).toString()+" days")
        } else if (diffHours < 24 && diffHours <=1) {
            return ((diffHours).toString()+" hrs")
        } else if (diffMinutes >= 1) {
            return ((diffMinutes).toString()+" mins")
        }
        return ""
    }
}