package com.gap.hellogiver.gateway

interface HelloGiverThemeService {
    fun getTheme(theme: HelloTheme): Int?

    sealed class HelloTheme {
        object PrimaryTheme : HelloTheme()
        object SecondaryTheme : HelloTheme()
    }
}
