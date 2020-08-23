package com.example.albumapp.core

import android.app.Application

class AlbumApplication:Application() {


    override fun onCreate() {
        super.onCreate()
        instance = this

    }

    companion object {
        lateinit var instance: AlbumApplication
            private set
    }
}