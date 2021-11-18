package com.gap.testlibraryfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }
}

sealed class CardState {

    data class CardWithBalance(
        val cardId: String
    ) : CardState()

    object UnderReview : CardState()
    object Rejected : CardState()
    data class Approved(val cardId: String) : CardState()
    data class NotRegistered(val cardId: String) : CardState()
}