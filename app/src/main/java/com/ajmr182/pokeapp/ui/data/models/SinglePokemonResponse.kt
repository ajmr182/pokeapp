package com.ajmr182.pokeapp.ui.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SinglePokemonResponse(
    var name: String? = null,
    var frontDefault: String? = null,
    var types: List<TypesPokemon>? = null,
    var weight: Int? = null
)

@Serializable
data class TypesPokemon(
    var slot: Int? = null,
    var type: TypePokemon? = null
)

@Serializable
data class TypePokemon(
    var name: String? = null,
    var url: String? = null
)