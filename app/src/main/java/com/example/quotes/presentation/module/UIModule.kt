package com.example.quotes.presentation.module

import com.example.quotes.presentation.ui.fragments.dialog.DialogViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { DialogViewModel(get(), get()) }
}