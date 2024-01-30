package com.ajmr182.pokeapp.ui.domain.usecases

import com.ajmr182.pokeapp.ui.data.models.SinglePokemonResponse
import com.ajmr182.pokeapp.ui.data.repository.PokemonRepositoryImpl

class GetSinglePokemonUseCase (private val pokemonRepositoryImpl: PokemonRepositoryImpl) {

    suspend fun obtainPokemon(pokemon:String): SinglePokemonResponse? {
        return pokemonRepositoryImpl.obtainSinglePokemon(pokemon)
    }
}