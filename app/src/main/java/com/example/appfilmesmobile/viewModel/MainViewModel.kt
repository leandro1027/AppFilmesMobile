package com.example.appfilmesmobile.viewModel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appfilmesmobile.model.PersonRepository

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val personRepository = PersonRepository()

    init {
        textWelcome.value = ""
    }

    fun getWelcome(): LiveData<String> {
        return textWelcome
    }

    fun getLogin(): LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, password: String) {
        login.value = personRepository.login(email, password)

    }
}