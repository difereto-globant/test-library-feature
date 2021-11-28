package com.gap.hellogiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class HelloGiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_giver)

        val extras = intent.extras
        val name = extras?.getString("Name")

        val label: TextView = findViewById(R.id.text_hello)
        label.text = "${HelloGiver.sayHello()} $name"

        Log.i("HelloGiverActivity", "Saying -> ${HelloGiver.sayHello()} $name")
    }
}
