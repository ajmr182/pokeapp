package com.ajmr182.pokeapp.src.data.repository

import com.ajmr182.pokeapp.src.data.Constants
import com.ajmr182.pokeapp.src.data.KtorClient
import com.ajmr182.pokeapp.src.data.models.PokemonResponse
import com.ajmr182.pokeapp.src.data.models.SinglePokemonResponse
import com.ajmr182.pokeapp.src.data.models.TypePokemon
import com.ajmr182.pokeapp.src.data.models.TypesPokemon
import com.google.gson.Gson
import com.google.gson.JsonParser
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json

class PokemonRepositoryImpl(private val client: KtorClient) : PokemonRepository {
    override suspend fun obtainPokemon(): PokemonResponse {
        return try {
            val response = client.client.get(Constants.baseUrl + "pokemon?limit=100000&offset=0")
            val responseBody: String = response.bodyAsText()
            val pokemonResponse: PokemonResponse = Json.decodeFromString(responseBody)

            pokemonResponse
        } catch (e: Exception) {
            PokemonResponse(count = 0, next = null, previous = null, results = emptyList())
        }
    }

    override suspend fun obtainSinglePokemon(pokemon:String): SinglePokemonResponse? {
        return try {
            val response = client.client.get(Constants.baseUrl + "pokemon/$pokemon")
            val responseBody: String = response.bodyAsText()
            val jsonTree = JsonParser.parseString(responseBody)
            val weight = jsonTree.asJsonObject.getAsJsonPrimitive("weight")?.asInt
            val name = jsonTree.asJsonObject.getAsJsonPrimitive("name")?.asString
            val spritesJson = jsonTree.asJsonObject.getAsJsonObject("sprites")
            val frontDefault = spritesJson.get("front_default")?.asString
            val typesArray = jsonTree.asJsonObject.getAsJsonArray("types")
            val typesList = typesArray.map { it.asJsonObject }
            val types = typesList.map { typeElement ->
                val slot = typeElement.getAsJsonPrimitive("slot").asInt
                val type = Gson().fromJson(typeElement.getAsJsonObject("type"), TypePokemon::class.java)
                TypesPokemon(slot = slot, type = type)
            }
            val pokemonResponse = SinglePokemonResponse(
               frontDefault = frontDefault,
                weight = weight,
                name = name,
                types = types
            )
            pokemonResponse
        } catch (e: Exception) {
            null
        }
    }
}