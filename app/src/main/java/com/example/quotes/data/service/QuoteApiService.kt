package com.example.quotes.data.service

import com.example.quotes.BuildConfig.API_KEY
import com.example.quotes.data.dto.quote.QuoteResponse
import com.example.quotes.data.dto.quote.QuoteResponseItem
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface QuoteApiService {

    @GET("quotes")
    suspend fun getQuote(
        @Query("category") category: String,
        @Header("X-Api-Key") apiKey: String = API_KEY
    ): QuoteResponse<QuoteResponseItem>
}