package com.example.quotes.presentation.utils

import android.app.Application
import android.content.SharedPreferences
import com.example.quotes.data.module.networkModule
import com.example.quotes.data.module.repoModule
import com.example.quotes.data.module.translateRepoModule
import com.example.quotes.data.module.translateRetrofit
import com.example.quotes.domain.module.domainModule
import com.example.quotes.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    private lateinit var preferences: SharedPreferences

    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        preferences = this.applicationContext
            .getSharedPreferences("setting", MODE_PRIVATE)
        prefs = Prefs(preferences)
        startKoin {
            androidContext(this@App)
            modules(networkModule,
                translateRetrofit,
                repoModule,
                translateRepoModule,
                domainModule,
                viewModelModule)
        }
    }
}