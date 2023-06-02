package com.example.quotes.data.service

import com.example.quotes.BuildConfig.TRANSLATE_API_KEY
import com.example.quotes.data.dto.translate.DataDto
import com.example.quotes.data.dto.translate.TranslateResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslateApiService {

    @GET("language/translate/v2")
    suspend fun getTranslateText(
        @Query("key") key: String = TRANSLATE_API_KEY,
        @Query("q") translateText: String = "",
        @Query("target") targetLang: String = "ru",
        @Query("source") sourceLang: String = "en"
    ): TranslateResponse
}