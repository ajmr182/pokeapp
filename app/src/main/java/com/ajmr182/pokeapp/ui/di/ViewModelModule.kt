package com.ajmr182.pokeapp.ui.di

import com.ajmr182.pokeapp.ui.feature.pokeDex.PokeDexViewModel
import com.ajmr182.pokeapp.ui.feature.pokemonDetail.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokeDexViewModel(get()) }
    viewModel { PokemonDetailViewModel(get()) }
}