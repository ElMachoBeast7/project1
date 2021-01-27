package com.android.example.rssreader

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    fun addList() : MutableList<FeedTopic> {
        val topic = mutableListOf<String>("Health", "UN Affairs", "Law and Crime Prevention", "Human Rights", "Humanitarian Aid", "Climate Change",
        "Culture and Education", "Economic Development", "Women", "Peace and Security", "Migrant and Refugees")
        val link = mutableListOf<String>("health", "un-affairs", "law-and-crime-prevention", "human-right", "humanitarian-aid", "climate change",
        "culture-and-education", "economic-development", "women", "peace-and-security", "migrants-and-refugees")
        val together = mutableListOf<FeedTopic>()
        for(i in 0 until link.size) {
            together.add(FeedTopic(topic[i], link[i]))
        }

        return together
    }

    val feed_list = addList()
    val feedAdapter = MainActivityAdapter(feed_list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ========== PHASE 3 : from here ==========================================================
        // TODO: Add RecyclerView here for all "feeds by topic" options
        //  found on https://news.un.org/en/rss-feeds
        // ========== PHASE 3 : to here ============================================================
        val rv = findViewById<RecyclerView>(R.id.activiy_main_recycle_view).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = feedAdapter
        }

       //===========================================================================================
    }
}
