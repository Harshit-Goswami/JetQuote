package com.example.composequotesapp

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.composequotesapp.modal.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object DataManager {
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quote? = null

    fun loadFromAssets(context: Context) {
        lateinit var jsonString: String
        try {
            jsonString = context.assets.open("quotes.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            Log.e("ioException", ioException.toString())
        }
        val quotetype = object : TypeToken<List<Quote>>() {}.type
        data = Gson().fromJson(jsonString, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTING) {
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        } else {
            currentPage.value = Pages.LISTING
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}