package com.gap.hellogiver.gateway.impl

import android.content.Context
import android.content.Intent
import com.gap.hellogiver.HelloDescActivity
import com.gap.hellogiver.gateway.HelloGiverActivityService
import com.gap.hellogiver.gateway.HelloGiverActivityService.HelloProvider

class HelloDescActivityServiceImpl : HelloGiverActivityService {

    override val type: HelloProvider = HelloProvider.HelloDesc

    override fun launchHelloGiverActivity(context: Context, name: String) {
        val intent = Intent(context, HelloDescActivity::class.java).apply { putExtra("Name", name) }
        context.startActivity(intent)
    }
}
