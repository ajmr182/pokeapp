package com.ajmr182.pokeapp.ui.domain.usecases

import com.ajmr182.pokeapp.ui.data.models.PokemonResponse
import com.ajmr182.pokeapp.ui.data.models.SinglePokemonResponse
import com.ajmr182.pokeapp.ui.data.repository.PokemonRepositoryImpl

class ObtainPokemonUseCase(private val pokemonRepositoryImpl: PokemonRepositoryImpl) {

    suspend fun obtainPokemon():PokemonResponse{
        return pokemonRepositoryImpl.obtainPokemon()
    }
}