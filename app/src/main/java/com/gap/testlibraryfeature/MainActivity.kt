package com.gap.testlibraryfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gap.hellogiver.gateway.HelloGiverThemeService.HelloTheme.SecondaryTheme
import com.gap.hellogiver.gateway.provider.HelloGiverThemeProvider
import com.gap.testlibraryfeature.databinding.MainActivityBinding
import com.gap.testlibraryfeature.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    private val helloThemeProvider = HelloGiverThemeProvider.getInstance()

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val theme = helloThemeProvider.getTheme(SecondaryTheme)
        theme?.run { setTheme(this) }
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }

        //val test: HelloGiverActivityService = HelloGiverActivityProvider.getInstance().getFirstAvailableService()
        //test.launchHelloGiverActivity(this, "Diego Recalde")
    }
}
