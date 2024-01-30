package com.ajmr182.pokeapp.ui.feature.pokemonDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import com.ajmr182.pokeapp.ui.theme.ColorRedLight
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.koin.androidx.compose.koinViewModel

class PokemonDetailScreen(private val pokemon: String) : Screen {

    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokemonDetailViewModel>()
        val pokemonInformation by viewModel.pokemonInformation.observeAsState()
        LaunchedEffect(pokemon) {
            viewModel.obtainSinglePokemon(pokemon)
        }
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorRedLight)
        ) {
            val (box1, text) = createRefs()
            Box(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxHeight(0.5f)
                    .padding(horizontal = 80.dp)
                    .background(Color.LightGray)
                    .constrainAs(box1) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }
            ) {
                Box(
                    Modifier
                        .padding(24.dp)
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    GlideImage(
                        modifier = Modifier.fillMaxSize(),
                        model = pokemonInformation?.frontDefault,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}