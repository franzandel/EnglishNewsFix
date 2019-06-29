package com.example.englishnewsfix.data.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
) : Parcelable