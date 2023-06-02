package com.example.quotes.data.module

import com.example.quotes.BuildConfig
import com.example.quotes.data.service.QuoteApiService
import com.example.quotes.data.service.TranslateApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val translateRetrofit = module {
    factory { provideTranslateOkHttpClientBuilder().build() }
    factory { provideTranslateApiService(provideTranslateOkHttpClientBuilder().build()) }
}

fun provideTranslateApiService(client: OkHttpClient): TranslateApiService =
    Retrofit.Builder()
        .baseUrl(BuildConfig.TRANSLATE_BASE_URl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
        .create(TranslateApiService::class.java)

fun provideTranslateOkHttpClientBuilder(): OkHttpClient.Builder = OkHttpClient()
    .newBuilder()
    .addInterceptor(provideTranslateLoggingInterceptor())
    .callTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .readTimeout(60, TimeUnit.SECONDS)
    .writeTimeout(60, TimeUnit.SECONDS)

private fun provideTranslateLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
    when {
        org.koin.android.BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }
)