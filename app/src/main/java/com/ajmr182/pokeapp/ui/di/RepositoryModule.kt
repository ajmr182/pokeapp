package com.ajmr182.pokeapp.ui.di

import com.ajmr182.pokeapp.ui.data.repository.PokemonRepositoryImpl
import com.ajmr182.pokeapp.ui.data.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { PokemonRepositoryImpl(get()) }
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}