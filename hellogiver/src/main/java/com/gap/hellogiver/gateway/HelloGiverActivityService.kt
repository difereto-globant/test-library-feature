package com.gap.hellogiver.gateway

import android.content.Context

interface HelloGiverActivityService {
    fun launchHelloGiverActivity(context: Context, name: String)
}
