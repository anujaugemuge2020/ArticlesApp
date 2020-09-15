package com.example.articlesapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.articlesapp.R.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, ArticlesActivity::class.java)
            startActivity(intent)
        }


    }
}