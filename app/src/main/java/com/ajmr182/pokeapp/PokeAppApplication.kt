package com.ajmr182.pokeapp

import android.app.Application
import com.ajmr182.pokeapp.src.di.useCaseModule
import com.ajmr182.pokeapp.src.di.networkModule
import com.ajmr182.pokeapp.src.di.repositoryModule
import com.ajmr182.pokeapp.src.di.screenModule
import com.ajmr182.pokeapp.src.di.viewModelModule
import org.koin.core.context.startKoin

class PokeAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(useCaseModule, networkModule, viewModelModule, repositoryModule, screenModule)
        }
    }
}