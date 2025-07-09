package com.example.mudea

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mudea.databinding.ActivityForgotPasswordBinding
import com.example.mudea.helpers.FirebaseHelper

class forgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createListeners()

    }

    fun createListeners(){
        binding.sendCodeEmailButton.setOnClickListener {
            var email = binding.inputEmail.text.toString()

            if (email.isNotEmpty()){
                FirebaseHelper.recuperarSenha(
                    email,
                    sucesso = {
                        Toast.makeText(this,
                            "O código foi enviado para o seu email!!",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish()
                    },
                    falha = {
                        erro ->
                        Toast.makeText(this,
                            "Ocorreu um erro: ${erro?.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }else{
                Toast.makeText(this, "Digite um email!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}