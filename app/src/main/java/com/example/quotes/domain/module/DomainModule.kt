package com.example.quotes.domain.module

import com.example.quotes.domain.usecases.GetQuoteUseCase
import com.example.quotes.domain.usecases.GetTranslateTextUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetQuoteUseCase(get()) }
    factory { GetTranslateTextUseCase(get()) }
}