package com.ajmr182.pokeapp.ui.feature.pokemonDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajmr182.pokeapp.ui.data.models.SinglePokemonResponse
import com.ajmr182.pokeapp.ui.domain.usecases.GetSinglePokemonUseCase
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val getSinglePokemonUseCase: GetSinglePokemonUseCase) :
    ViewModel() {

    private val _pokemonInformation = MutableLiveData<SinglePokemonResponse?>()
    val pokemonInformation: LiveData<SinglePokemonResponse?> get() = _pokemonInformation

    fun obtainSinglePokemon(pokemon:String){
        viewModelScope.launch {
            val response = getSinglePokemonUseCase.obtainPokemon(pokemon)
            _pokemonInformation.value = response
        }
    }
}