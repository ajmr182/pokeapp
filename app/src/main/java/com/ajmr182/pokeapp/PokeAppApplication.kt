package com.ajmr182.pokeapp

import android.app.Application
import com.ajmr182.pokeapp.ui.di.useCaseModule
import com.ajmr182.pokeapp.ui.di.networkModule
import com.ajmr182.pokeapp.ui.di.repositoryModule
import com.ajmr182.pokeapp.ui.di.screenModule
import com.ajmr182.pokeapp.ui.di.viewModelModule
import org.koin.core.context.startKoin

class PokeAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(useCaseModule, networkModule, viewModelModule, repositoryModule, screenModule)
        }
    }
}