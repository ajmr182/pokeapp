package com.ajmr182.pokeapp.ui.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    @SerializedName("count") var count: Int?,
    @SerializedName("next") var next: String?,
    @SerializedName("previous") var previous: String?,
    @SerializedName("results") var results: List<Results?>
)

@Serializable
data class Results(
    @SerializedName("name") var name: String?,
    @SerializedName("url") var url: String?
)
