package com.gap.hellogiver.gateway.provider

import com.gap.hellogiver.gateway.HelloGiverThemeService
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme
import java.util.ServiceLoader

class HelloGiverThemeProvider {

    private var themeLoader: ServiceLoader<HelloGiverThemeService>? = ServiceLoader.load(HelloGiverThemeService::class.java)

    fun getTheme(theme: HelloTheme): Int? {
        for (loader in themeLoader?.iterator()!!) {
            val requiredTheme: Int? = loader.getTheme(theme)
            if (requiredTheme != null) return requiredTheme
        }
        return null
    }

    companion object {
        @Volatile private var INSTANCE: HelloGiverThemeProvider? = null

        fun getInstance(): HelloGiverThemeProvider {
            val cachedInstance = INSTANCE
            if (cachedInstance != null) return cachedInstance

            synchronized(this) {
                val instance = HelloGiverThemeProvider()
                INSTANCE = instance
                return instance
            }
        }
    }
}
