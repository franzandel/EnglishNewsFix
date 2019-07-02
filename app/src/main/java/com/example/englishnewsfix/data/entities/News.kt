package com.example.englishnewsfix.data.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//@Parcelize
//data class News(
//    val articles: List<Article>,
//    val status: String,
//    val totalResults: Int
//) : Parcelable

@Parcelize
open class News (
    @SerializedName("articles")
    @Expose
    var articles: List<Article>,

    @SerializedName("status")
    @Expose
    var status: String? = null,

    @SerializedName("totalResults")
    @Expose
    var totalResults: Int? = null
) : Parcelable