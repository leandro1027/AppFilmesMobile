package com.example.appfilmesmobile.model

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PersonRepository {
    fun login(email : String, password : String): Boolean{
        return (email == "leandrobalaban78@gmail.com" && password == "12345")
    }
}
