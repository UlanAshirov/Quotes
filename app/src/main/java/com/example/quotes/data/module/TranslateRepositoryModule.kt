package com.example.quotes.data.module

import com.example.quotes.data.repository.TranslateRepositoryImpl
import com.example.quotes.domain.repository.TranslateRepository
import org.koin.dsl.module

val translateRepoModule = module {
    single<TranslateRepository> { TranslateRepositoryImpl(get()) }
}