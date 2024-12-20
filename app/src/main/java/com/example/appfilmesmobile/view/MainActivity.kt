package com.example.appfilmesmobile.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.appfilmesmobile.R
import com.example.appfilmesmobile.databinding.ActivityMainBinding
import com.example.appfilmesmobile.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener(this)

        //Instanciando o MainViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setObserver()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonLogin){
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            //atribuindo responsabilidade para a viewModel
            viewModel.doLogin(email, password)
        }
    }

    private fun setObserver() {
        viewModel.getWelcome().observe(this, Observer() {
            binding.textWelcome.text = it
        })

        viewModel.getLogin().observe(this, Observer() {
            if (it){
                startActivity(Intent(this,UserActivity::class.java))
            }else{
                Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        })
    }
}