package com.android.example.rssreader

import android.content.ClipData
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivityAdapter(private val mMainList: MutableList<FeedTopic>) : RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {

    class MainActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val entryView: LinearLayout = itemView.findViewById(R.id.linearLayout)
        val categoryView: TextView = itemView.findViewById(R.id.main_category)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MainActivityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.activity_main_item, parent, false)

        return MainActivityViewHolder(view)
    }

    override fun getItemCount() : Int {
        return mMainList.size
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.categoryView.text = mMainList[position].topic

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, FeedActivity::class.java)
            intent.putExtra("feed", mMainList[position])
            ContextCompat.startActivity(it.context, intent,null)
        }

    }
}