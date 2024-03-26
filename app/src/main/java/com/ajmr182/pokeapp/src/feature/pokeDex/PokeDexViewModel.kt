package com.ajmr182.pokeapp.src.feature.pokeDex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajmr182.pokeapp.src.data.models.PokemonResponse
import com.ajmr182.pokeapp.src.domain.usecases.ObtainPokemonUseCase
import kotlinx.coroutines.launch

class PokeDexViewModel(
    private val obtainPokemonUseCase : ObtainPokemonUseCase
):ViewModel() {

    private val _pokemonList = MutableLiveData<PokemonResponse>()
    val pokemonList: LiveData<PokemonResponse> get() = _pokemonList

    fun obtainPokemon(){
        viewModelScope.launch {
           val response = obtainPokemonUseCase.obtainPokemon()
            _pokemonList.value = response
        }
    }
}