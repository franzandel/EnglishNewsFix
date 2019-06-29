package com.example.englishnewsfix.presentation.adapter

import com.example.englishnewsfix.R
import com.example.englishnewsfix.data.entities.Article
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.news_row.view.*

class NewsRow(val articles: Article): Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.news_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        if (articles.source?.id.equals(null)) {
            val id = articles.source?.name?.substringBefore('.')
            viewHolder.itemView.textView_username_News?.text = id
        } else
            viewHolder.itemView.textView_username_News?.text = articles.source?.id

        viewHolder.itemView.textView_latestMessage_News?.text = articles.source?.name
    }
}