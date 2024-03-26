package com.ajmr182.pokeapp.src.di

import com.ajmr182.pokeapp.src.feature.pokeDex.PokeDexViewModel
import com.ajmr182.pokeapp.src.feature.pokemonDetail.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokeDexViewModel(get()) }
    viewModel { PokemonDetailViewModel(get()) }
}