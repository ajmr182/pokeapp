package com.ajmr182.pokeapp.src.di

import com.ajmr182.pokeapp.src.domain.usecases.GetSinglePokemonUseCase
import com.ajmr182.pokeapp.src.domain.usecases.ObtainPokemonUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { ObtainPokemonUseCase(get()) }
    single { GetSinglePokemonUseCase(get()) }
}