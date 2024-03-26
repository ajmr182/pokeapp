package com.ajmr182.pokeapp.src.feature.pokeDex

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.ajmr182.pokeapp.src.domain.utils.getImageByIdNumber
import com.ajmr182.pokeapp.src.feature.pokemonDetail.PokemonDetailScreen
import com.ajmr182.pokeapp.src.theme.ColorRedLight
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import org.koin.androidx.compose.koinViewModel

class PokeDexScreen : Screen {
    @OptIn(ExperimentalGlideComposeApi::class)
    @Composable
    override fun Content() {
        val viewModel = koinViewModel<PokeDexViewModel>()
        val lazyColumState = rememberLazyListState()
        val navigation = LocalNavigator.current
        LaunchedEffect(true) {
            viewModel.obtainPokemon()
        }
        val pokemonResponse by viewModel.pokemonList.observeAsState()
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(ColorRedLight)
        ) {
            LazyColumn(state = lazyColumState) {
                val chunkedResults = pokemonResponse?.results?.chunked(3) ?: emptyList()
                items(chunkedResults) { rowItems ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)

                    ) {
                        rowItems.forEach { item ->
                            Column(
                                modifier = Modifier.weight(0.33f).clickable { navigation?.push(PokemonDetailScreen(item?.name?:"")) },
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                GlideImage(
                                    modifier = Modifier.height(100.dp),
                                    model = getImageByIdNumber(item?.url ?: ""),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop
                                )
                                Text(item?.name ?: "")
                            }
                        }
                    }
                }
            }
        }
    }
}