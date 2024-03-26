package com.ajmr182.pokeapp.src.domain.usecases

import com.ajmr182.pokeapp.src.data.models.SinglePokemonResponse
import com.ajmr182.pokeapp.src.data.repository.PokemonRepositoryImpl

class GetSinglePokemonUseCase (private val pokemonRepositoryImpl: PokemonRepositoryImpl) {

    suspend fun obtainPokemon(pokemon:String): SinglePokemonResponse? {
        return pokemonRepositoryImpl.obtainSinglePokemon(pokemon)
    }
}