package com.example.englishnewsfix.data.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val author: String ?= null,
    val content: String ?= null,
    val description: String ?= null,
    val publishedAt: String ?= null,
    val source: Source?= null,
    val title: String ?= null,
    val url: String ?= null,
    val urlToImage: String ?= null
) : Parcelable

//@Parcelize
//data class Article(
//    @SerializedName("articles")
//    @Expose
//    val author: String ?= null,
//    val content: String ?= null,
//    val description: String ?= null,
//    val publishedAt: String ?= null,
//    val source: Source?= null,
//    val title: String ?= null,
//    val url: String ?= null,
//    val urlToImage: String ?= null
//) : Parcelable