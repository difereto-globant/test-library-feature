package com.gap.hellogiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

internal class HelloDescActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_desc)

        val extras = intent.extras
        val name = extras?.getString("Name")

        val title: TextView = findViewById(R.id.text_title)
        title.text = "${HelloGiver.sayHi()} $name!"

        Log.i("HelloDescActivity", "Saying -> ${HelloGiver.sayHello()} $name!")
    }
}
