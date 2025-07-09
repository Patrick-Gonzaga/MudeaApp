package com.example.mudea

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mudea.databinding.ActivityLoginBinding
import com.example.mudea.helpers.FirebaseHelper

class loginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createListeners()

    }

    fun createListeners() {
        binding.btnNovaConta.setOnClickListener {
            val intent = Intent(this, registerActivity::class.java)
            startActivity(intent)
        }
        binding.btnEsqueceu.setOnClickListener {
            val intent = Intent(this, forgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.enterButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            var email = binding.inputEmail.text.toString()
            var senha = binding.inputPassword.text.toString()
            if (email.isNotEmpty()) {
                if (senha.isNotEmpty()) {
                    FirebaseHelper.logar(
                        email, senha, sucesso = { usuario ->
                            Toast.makeText(
                                this,
                                "Login concluído com email: ${usuario?.email}",
                                Toast.LENGTH_SHORT
                            ).show()
                            startActivity(intent)
                            finish()
                        },
                        falha = { erro ->
                            Toast.makeText(
                                this,
                                "Erro no login: ${erro?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        })

                } else {
                    Toast.makeText(this, "Digite sua senha!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Digite seu email!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}