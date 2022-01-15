package com.example.copypasteapplication.service

import android.app.Service
import android.content.ClipboardManager
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

class BackgroundService : Service() {
    lateinit var clipBoardManager: ClipboardManager

    override fun onCreate() {
        Toast.makeText(this, "background service is created", Toast.LENGTH_LONG).show();
        clipBoardManager = applicationContext.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? {
        throw UnsupportedOperationException("Not yet implemented");
    }

}