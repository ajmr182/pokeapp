package com.ajmr182.pokeapp.src.di

import com.ajmr182.pokeapp.src.data.repository.PokemonRepositoryImpl
import com.ajmr182.pokeapp.src.data.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { PokemonRepositoryImpl(get()) }
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}