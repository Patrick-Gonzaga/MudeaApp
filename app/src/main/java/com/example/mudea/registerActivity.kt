package com.example.mudea

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mudea.databinding.ActivityRegisterBinding
import com.example.mudea.helpers.FirebaseHelper

class registerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createListeners()

    }

    fun createListeners() {
        binding.registerButton.setOnClickListener {
            var email = binding.inputEmail.text.toString()
            var senha = binding.inputPassword.text.toString()
            var senha2 = binding.inputPasswordRep.text.toString()
            if (email.isNotEmpty()) {
                when (true) {
                    senha.isEmpty() -> Toast.makeText(this, "Digite uma senha!!", Toast.LENGTH_SHORT)
                        .show()

                    (senha.length < 8) -> Toast.makeText(
                        this,
                        "Digite uma senha com no mínimo 8 caracteres.", Toast.LENGTH_SHORT
                    ).show()

                    senha2.isEmpty() -> Toast.makeText(this, "Repita sua senha!!", Toast.LENGTH_SHORT)
                        .show()

                    (senha != senha2) -> Toast.makeText(
                        this,
                        "As senhas não coincidem",
                        Toast.LENGTH_SHORT
                    ).show()

                    else -> {
                        FirebaseHelper.criarConta(
                            email, senha,
                            sucesso = { usuario ->
                                Toast.makeText(
                                    this,
                                    "Registro concluído com sucesso com o email ${usuario?.email}",
                                    Toast.LENGTH_SHORT
                                ).show()
                                finish()
                            },
                            falha = { erro ->
                                Toast.makeText(
                                    this,
                                    "Erro no login: ${erro?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            })

                    }
                }


            } else {
                Toast.makeText(this, "Digite um email!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

/* FirebaseHelper.criarConta(email,senha,
                        sucesso = {usuario ->
                            Toast.makeText(this,"Registro concluído com sucesso com o email ${usuario?.email}",Toast.LENGTH_SHORT).show()
                    },
                        falha = {erro ->
                            Toast.makeText(this,"Erro no login: ${erro?.message}", Toast.LENGTH_SHORT).show()
                        }) */