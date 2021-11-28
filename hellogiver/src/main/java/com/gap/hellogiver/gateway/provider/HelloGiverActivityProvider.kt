package com.gap.hellogiver.gateway.provider

import java.util.*
import kotlin.NoSuchElementException

class HelloGiverActivityProvider {

    private var loader: ServiceLoader<HelloGiverActivityProvider>? = null

    init {
        loader = ServiceLoader.load(HelloGiverActivityProvider::class.java)
    }

    fun serviceImpl(): HelloGiverActivityProvider {
        return loader?.iterator()?.next() ?: throw NoSuchElementException("No implementation for GreetingsProvider")
    }

    companion object {
        @Volatile
        private var INSTANCE: HelloGiverActivityProvider? = null

        fun getInstance(): HelloGiverActivityProvider {
            val cachedInstance = INSTANCE
            if (cachedInstance != null) {
                return cachedInstance
            }
            synchronized(this) {
                val instance = HelloGiverActivityProvider()
                INSTANCE = instance
                return instance
            }
        }
    }
}
