package com.example.copypasteapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copypasteapplication.fragments.HomeFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = HomeFragment()
        this.supportFragmentManager.beginTransaction()
            .replace(R.id.activity_main_container, fragment)
            .addToBackStack(this::class.java.name)
            .commit()
    }
}