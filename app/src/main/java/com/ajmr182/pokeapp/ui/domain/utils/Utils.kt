package com.ajmr182.pokeapp.ui.domain.utils

fun getImageByIdNumber(url:String):String{
    val pattern = Regex("/pokemon/(\\d+)/")
    val matchResult = pattern.find(url)

    val pokemonNumber = matchResult?.groupValues?.get(1)
    return if(!pokemonNumber.isNullOrEmpty()){
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonNumber.png"
    }else{
        ""
    }
}