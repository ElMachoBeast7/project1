package com.android.example.rssreader

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.android.example.rssreader.model.Item
import org.w3c.dom.Text

class FeedListAdapter(private val mArticleList: MutableList<Item>) : RecyclerView.Adapter<InfoViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_feed_item, parent, false)

        val holder = InfoViewHolder(view)
        holder.itemView.setOnClickListener {
            Toast.makeText(it.context, holder.articleView.text, Toast.LENGTH_SHORT).show()
        }

        return holder
    }

    override fun getItemCount(): Int {
        return mArticleList.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        holder.articleView.text = mArticleList[position].title
        holder.feedDate.text = mArticleList[position].pubDate

        holder.entryView.setOnClickListener{
            val intent = Intent(it.context, NewsArticleActivity::class.java)
            intent.putExtra("item", mArticleList[position])
            startActivity(it.context, intent, null)
        }

    }



}

class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val entryView: LinearLayout = itemView.findViewById(R.id.feed_list)
    val articleView: TextView = itemView.findViewById(R.id.feed_name)
    val feedDate: TextView = itemView.findViewById(R.id.feed_date)



}