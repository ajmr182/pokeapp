package com.ajmr182.pokeapp.src.di

import com.ajmr182.pokeapp.src.data.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
}