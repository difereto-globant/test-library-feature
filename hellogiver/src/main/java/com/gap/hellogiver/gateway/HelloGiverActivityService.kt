package com.gap.hellogiver.gateway

import android.content.Context

interface HelloGiverActivityService {
    val type: HelloProvider

    fun launchHelloGiverActivity(context: Context, name: String)

    sealed class HelloProvider {
        object HelloGiver : HelloProvider()
        object HelloDesc : HelloProvider()
    }
}
