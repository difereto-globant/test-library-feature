package com.gap.hellogiver.gateway.impl

import android.content.Context
import android.content.Intent
import com.gap.hellogiver.HelloGiverActivity
import com.gap.hellogiver.gateway.HelloGiverActivityService
import com.gap.hellogiver.gateway.HelloGiverActivityService.HelloProvider

class HelloGiverActivityServiceImpl : HelloGiverActivityService {

    override val type: HelloProvider = HelloProvider.HelloGiver

    override fun launchHelloGiverActivity(context: Context, name: String) {
        val intent = Intent(context, HelloGiverActivity::class.java).apply { putExtra("Name", name) }
        context.startActivity(intent)
    }
}
