package com.ajmr182.pokeapp.ui.di

import com.ajmr182.pokeapp.ui.feature.pokeDex.PokeDexScreen
import com.ajmr182.pokeapp.ui.feature.pokemonDetail.PokemonDetailScreen
import org.koin.dsl.module

val screenModule = module {
    factory { PokeDexScreen() }
    factory { PokemonDetailScreen(get()) }
}