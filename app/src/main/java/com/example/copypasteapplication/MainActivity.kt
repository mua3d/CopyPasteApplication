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
        clipBoardData = "hi"

        val sharedPreferences= this.getSharedPreferences(clipBoardData,Context.MODE_PRIVATE)


        binding.syncButton.setOnClickListener {
            val startServiceIntent = Intent(this, BackgroundService::class.java)
            startService(startServiceIntent)
        }

        clipBoardManager = baseContext.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipBoardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()

        binding.applyButton.setOnClickListener {
            clipBoardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
            binding.clipBoardData.text = clipBoardData

        }

        clipBoardManager.addPrimaryClipChangedListener {
            clipBoardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
            binding.clipBoardData.text = clipBoardData
        }

    }


    override fun onResume() {
        super.onResume()

        if(clipBoardData.get == null) {
                clipBoardData = clipBoardManager.primaryClip?.toString()
                binding.clipBoardData.text = clipBoardData

            }else
                binding.clipBoardData.text = clipBoardData

        Log.d(TAG,"data from clipboard : $clipBoardData")

    }

    override fun onPause() {
        super.onPause()
        val editor:SharedPreferences.Editor =  clipBoardData.edit()

        editor.putString("data",data)
        editor.apply()
        editor.commit()
    }

}