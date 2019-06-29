package com.example.englishnewsfix.data.network

import com.google.gson.annotations.SerializedName

class ErrorResponse {
    @SerializedName("field")
    var field : String? = null
    @SerializedName("code")
    var code: Int? = null
    @SerializedName("message")
    var message: String? = null
}
