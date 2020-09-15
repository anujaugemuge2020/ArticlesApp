package com.example.articlesapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.articlesapp.database.ArticleEntity
import com.example.articlesapp.databinding.ArticleItemBinding
import com.squareup.picasso.Picasso
import java.util.Collections.emptyList


class ArticleAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var articles = emptyList<ArticleEntity?>() // Cached copy of words

    inner class ArticleViewHolder(val binding: ArticleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ArticleItemBinding.inflate(layoutInflater)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val currentUser = articles[position]
        holder.binding.article = currentUser
        holder.binding.executePendingBindings()
        Picasso.get()
            .load(currentUser?.userUrl)
            .into(holder.binding.userImage)
        Picasso.get()
            .load(currentUser?.articleUrl)
            .into(holder.binding.articleImage)
    }

    internal fun setWords(articles: List<ArticleEntity?>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    override fun getItemCount() = articles.size


    @BindingAdapter(value = ["setImageUrl"])
    fun ImageView.bindImageUrl(url: String?) {
        if (url != null && url.isNotBlank()) {

            Picasso.get()
                .load(url)
                .into(this)
        }
    }

}