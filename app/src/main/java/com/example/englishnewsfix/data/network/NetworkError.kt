package com.example.englishnewsfix.data.network

import com.google.gson.Gson
import com.google.gson.JsonParser
import retrofit2.HttpException
import java.io.IOException

class NetworkError(var err: Throwable) : Throwable() {

    companion object {
        private var DEFAULT_ERROR_MESSAGE = "Something went wrong! Please try again."
        const val NETWORK_ERROR_MESSAGE = "No Internet Connection!"
    }

    lateinit var mErrorResponse: ErrorResponse
    private var mListErrorResponse = ArrayList<String>()

    fun getErrorMessage(): String {
        if (err is IOException) {
            return NETWORK_ERROR_MESSAGE
        }
        if (err !is HttpException) {
            return DEFAULT_ERROR_MESSAGE
        }
        if (getHttpErrorCode()!! == 404 || getHttpErrorCode()!! >= 500) {
            DEFAULT_ERROR_MESSAGE = "Server sedang bermasalah"
        } else {
            val response = (err as HttpException).response()
            if (response != null) {
                DEFAULT_ERROR_MESSAGE = "Periksa kembali kode sms pin Anda"
            }
        }


        return DEFAULT_ERROR_MESSAGE
    }

    /**
     * Get Http Error Code
     * @Return 200,300,400,etc
     * */

    fun getHttpErrorCode(): Int? {
        return when (err) {
            is IOException -> return 0
            is HttpException -> (err as HttpException).code()
            else -> 0
        }
    }

    /**
     * Get Json Error Code
     *  @Return Assa Error Code
     * */

    fun getJsonErrorCode(): Int? {
        /*try {
            if (err is IOException) {
                return 0
            }
            if (err !is HttpException) {
                return 0
            }
            val response = (err as HttpException).response()
            val jsonString = response.errorBody()!!.string()
            val errorResponse = Gson().fromJson(jsonString, BaseApiResponse::class.java)


            return if (errorResponse?.code != null) {
                errorResponse.code
            } else {
                0
            }
        } catch (e: Exception) {
            //Except Get Loan
            return 0
        }*/
        return null
    }

    /*private fun getJsonStringFromResponse(response: retrofit2.Response<*>): String? {
        *//*val jsonString = response.errorBody()!!.string()
        val errorResponse = Gson().fromJson(jsonString, BaseApiResponse::class.java)
        return try {
            //For get Loans
            errorResponse.error?.get(0)?.message
        } catch (e: Exception) {
            //Except Get Loan
            errorResponse.message
        }*//*
        return null
    }*/

    /**
     * Json Field Error From AASA
     * */

    fun getJsonFieldErrorResponse(): List<String>? {
        val response = (err as HttpException).response()
        val jsonString = response?.errorBody()?.string()
        val parser = JsonParser()
        val elem = parser.parse(jsonString)
        val elemArr = elem.asJsonArray
        if (mListErrorResponse.size > 0) {
            mListErrorResponse.clear()
        }
        for (data in elemArr) {
            mErrorResponse = Gson().fromJson(data, ErrorResponse::class.java)
            val fieldError = mErrorResponse.field
            fieldError?.let {
                if (it.contains(".")) {
                    mListErrorResponse.add(it.split(".")[1])
                } else {
                    mListErrorResponse.add(it)
                }
            }
        }
        return mListErrorResponse


    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val that = other as NetworkError?

        return err == that!!.err
    }

    override fun hashCode(): Int {
        return err.hashCode()
    }

}