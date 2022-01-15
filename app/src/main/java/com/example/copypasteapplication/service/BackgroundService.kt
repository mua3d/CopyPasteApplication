package com.example.copypasteapplication.service

import android.app.IntentService
import android.app.Service
import android.content.ClipboardManager
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext

class BackgroundService : IntentService(BackgroundService::class.simpleName){


    override fun onHandleIntent(workingIntent: Intent?) {
    }
}