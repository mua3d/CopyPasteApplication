package com.example.copypasteapplication

import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.example.copypasteapplication.databinding.ActivityMainBinding
import com.example.copypasteapplication.service.BackgroundService



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var clipBoardManager : ClipboardManager
    private var clipBoardData: String? = null
    private val TAG = MainActivity::class.java.name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        clipBoardManager = baseContext.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipBoardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()

        binding.showButton.setOnClickListener {
            clipBoardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
            binding.clipBoardData.text = clipBoardData

        }

    }

}