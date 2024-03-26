package com.ajmr182.pokeapp.src.data.repository

import com.ajmr182.pokeapp.src.data.models.PokemonResponse
import com.ajmr182.pokeapp.src.data.models.SinglePokemonResponse

interface PokemonRepository {
    suspend fun obtainPokemon(): PokemonResponse

    suspend fun obtainSinglePokemon(pokemon:String): SinglePokemonResponse?
}