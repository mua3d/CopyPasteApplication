package com.example.copypasteapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.copypasteapplication.databinding.FragmentHomeBinding
import android.content.ClipData
import android.content.ClipData.Item
import android.content.ClipboardManager

import android.content.ClipboardManager.OnPrimaryClipChangedListener

import android.content.Context.CLIPBOARD_SERVICE
import android.util.Log
import androidx.core.content.ContextCompat

import androidx.core.content.ContextCompat.getSystemService




class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    private var clipboardData : String? = null
    private val TAG = HomeFragment::class.java.name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root

        val clipBoardManager = requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        clipBoardManager.addPrimaryClipChangedListener {
            clipboardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
        }

        binding.applyButton.setOnClickListener {
            clipboardData = clipBoardManager.primaryClip?.getItemAt(0)?.text?.toString()
            binding.clipBoardData.text = clipboardData
            Log.d(TAG, "clipBoardData : $clipboardData")
        }

        return view
    }

}