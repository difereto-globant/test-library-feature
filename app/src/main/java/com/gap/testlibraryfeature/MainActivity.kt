package com.gap.testlibraryfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gap.hellogiver.gateway.HelloGiverActivityService
import com.gap.hellogiver.gateway.provider.HelloGiverActivityProvider
import com.gap.testlibraryfeature.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        val test: HelloGiverActivityService = HelloGiverActivityProvider.getInstance().serviceImpl()
        test.launchHelloGiverActivity(this, "Diego Recalde")
    }
}
