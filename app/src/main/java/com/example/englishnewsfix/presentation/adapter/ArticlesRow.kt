package com.example.englishnewsfix.presentation.adapter

import com.example.englishnewsfix.R
import com.example.englishnewsfix.data.entities.Article
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.articles_row.view.*

class ArticlesRow(private val article: Article): Item<ViewHolder>() {
    override fun getLayout(): Int {
        return R.layout.articles_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textView_username_Articles?.text = article.title
        viewHolder.itemView.textView_latestMessage_Articles?.text = article.description

        if (article.urlToImage.equals(null))
            viewHolder.itemView.circleImageView_Articles.setBackgroundResource(android.R.drawable.star_big_on)
        else
            Picasso.get().load(article.urlToImage)
                .into(viewHolder.itemView.circleImageView_Articles)
    }
}