package com.ajmr182.pokeapp.ui.data.repository

import com.ajmr182.pokeapp.ui.data.models.PokemonResponse
import com.ajmr182.pokeapp.ui.data.models.SinglePokemonResponse

interface PokemonRepository {
    suspend fun obtainPokemon(): PokemonResponse

    suspend fun obtainSinglePokemon(pokemon:String): SinglePokemonResponse?
}