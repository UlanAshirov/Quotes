package com.example.quotes.data.module

import com.example.quotes.data.repository.QuoteRepositoryImpl
import com.example.quotes.domain.repository.QuoteRepository
import org.koin.dsl.module

val repoModule = module {
    single<QuoteRepository> { QuoteRepositoryImpl(get()) }
}