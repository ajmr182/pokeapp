package com.ajmr182.pokeapp.src.di

import com.ajmr182.pokeapp.src.feature.pokeDex.PokeDexScreen
import com.ajmr182.pokeapp.src.feature.pokemonDetail.PokemonDetailScreen
import org.koin.dsl.module

val screenModule = module {
    factory { PokeDexScreen() }
    factory { PokemonDetailScreen(get()) }
}