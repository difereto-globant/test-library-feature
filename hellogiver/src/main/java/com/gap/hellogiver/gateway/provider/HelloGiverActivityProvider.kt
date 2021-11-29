package com.gap.hellogiver.gateway.provider

import com.gap.hellogiver.gateway.HelloGiverActivityService
import com.gap.hellogiver.gateway.HelloGiverActivityService.HelloProvider
import java.util.ServiceLoader
import kotlin.NoSuchElementException

class HelloGiverActivityProvider {

    private var loader: ServiceLoader<HelloGiverActivityService>? = ServiceLoader.load(HelloGiverActivityService::class.java)

    fun getFirstAvailableService(): HelloGiverActivityService {
        return loader?.iterator()?.next() ?: throw NoSuchElementException("No implementation for HelloGiverActivityProvider")
    }

    fun getHelloServiceImpl(helloProviderType: HelloProvider): HelloGiverActivityService? {
        val loaderIterator = loader?.iterator()
        if (loaderIterator != null) {
            for (helloService in loaderIterator) {
                if (helloService.type == helloProviderType) return helloService
            }
        }
        return null
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
