package com.ajmr182.pokeapp.src.domain.usecases

import com.ajmr182.pokeapp.src.data.models.PokemonResponse
import com.ajmr182.pokeapp.src.data.repository.PokemonRepositoryImpl

class ObtainPokemonUseCase(private val pokemonRepositoryImpl: PokemonRepositoryImpl) {

    suspend fun obtainPokemon():PokemonResponse{
        return pokemonRepositoryImpl.obtainPokemon()
    }
}