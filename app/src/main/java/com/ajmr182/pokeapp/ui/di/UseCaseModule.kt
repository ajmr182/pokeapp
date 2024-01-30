package com.ajmr182.pokeapp.ui.di

import com.ajmr182.pokeapp.ui.domain.usecases.GetSinglePokemonUseCase
import com.ajmr182.pokeapp.ui.domain.usecases.ObtainPokemonUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { ObtainPokemonUseCase(get()) }
    single { GetSinglePokemonUseCase(get()) }
}