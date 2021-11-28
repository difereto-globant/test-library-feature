package com.gap.hellogiver.gateway.provider

import com.gap.hellogiver.gateway.HelloGiverActivityService
import java.util.ServiceLoader
import kotlin.NoSuchElementException

class HelloGiverActivityProvider {

    private var loader: ServiceLoader<HelloGiverActivityService>? = ServiceLoader.load(HelloGiverActivityService::class.java)

    fun serviceImpl(): HelloGiverActivityService {
        return loader?.iterator()?.next() ?: throw NoSuchElementException("No implementation for GreetingsProvider")
    }

    companion object {
        @Volatile private var INSTANCE: HelloGiverActivityProvider? = null

        fun getInstance(): HelloGiverActivityProvider {
            val cachedInstance = INSTANCE
            if (cachedInstance != null) return cachedInstance

            synchronized(this) {
                val instance = HelloGiverActivityProvider()
                INSTANCE = instance
                return instance
            }
        }
    }
}
