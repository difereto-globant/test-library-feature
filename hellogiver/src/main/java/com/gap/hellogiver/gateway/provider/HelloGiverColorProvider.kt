package com.gap.hellogiver.gateway.provider

import com.gap.hellogiver.gateway.HelloGiverColorService
import java.util.ServiceLoader
import kotlin.NoSuchElementException

class HelloGiverColorProvider {

    private var loader: ServiceLoader<HelloGiverColorService>? = ServiceLoader.load(HelloGiverColorService::class.java)

    fun getColorServiceImpl(): HelloGiverColorService {
        return loader?.iterator()?.next() ?: throw NoSuchElementException("No implementation for HelloGiverActivityProvider")
    }

    companion object {
        @Volatile private var INSTANCE: HelloGiverColorProvider? = null

        fun getInstance(): HelloGiverColorProvider {
            val cachedInstance = INSTANCE
            if (cachedInstance != null) return cachedInstance

            synchronized(this) {
                val instance = HelloGiverColorProvider()
                INSTANCE = instance
                return instance
            }
        }
    }
}
