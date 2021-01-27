package com.android.example.rssreader

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.example.rssreader.model.Item
import kotlinx.android.synthetic.main.activity_feed_item.*


class NewsArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_article)

        // TODO PHASE 2
        val activity_news_date = findViewById<TextView>(R.id.activity_news_date)
        val activity_news_title = findViewById<TextView>(R.id.activity_news_title)
        val activity_news_summary = findViewById<TextView>(R.id.activity_news_summary)
        val activity_news_button = findViewById<Button>(R.id.activity_news_button)
        val myVariable : Item? = intent.getParcelableExtra("item")!!

        if (myVariable != null) {
            activity_news_date.text = myVariable.pubDate
        }
        if (myVariable != null) {
            activity_news_title.text = myVariable.title
        }
        if (myVariable != null) {
            activity_news_summary.text = myVariable.description
        }

        findViewById<Button>(R.id.activity_news_button).setOnClickListener {
            val implicit = Intent(Intent.ACTION_VIEW, Uri.parse(myVariable?.link))
            startActivity(implicit)


        }



        }


    }
