package com.example.appfilmesmobile.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfilmesmobile.R
import com.example.appfilmesmobile.databinding.ActivityMainBinding
import com.example.appfilmesmobile.databinding.ActivityUserBinding
import com.example.appfilmesmobile.viewModel.MainViewModel

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}