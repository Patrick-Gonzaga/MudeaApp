package com.example.mudea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mudea.databinding.ActivityLoginBinding

class activity_login : AppCompatActivity() {
    private val binding:ActivityLoginBinding by lazy{
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

    }
}