package com.example.mudea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mudea.databinding.ActivityRegisterBinding
import com.example.mudea.helpers.FirebaseHelper
import com.example.mudea.util.BottomSheetDialog

class RegisterActivity : AppCompatActivity() {

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
                    senha.isEmpty() -> BottomSheetDialog(
                        message = "Digite uma senha!!",
                    ).show(supportFragmentManager, "BottomSheetDialog")
                    /*Toast.makeText(this, "Digite uma senha!!", Toast.LENGTH_SHORT)
                        .show()*/

                    (senha.length < 8) -> BottomSheetDialog(
                        message = "Digite uma senha com no mínimo 8 caracteres.",
                    ).show(supportFragmentManager, "BottomSheetDialog")
                    /*Toast.makeText(
                        this,
                        "Digite uma senha com no mínimo 8 caracteres.", Toast.LENGTH_SHORT
                    ).show()*/

                    senha2.isEmpty() -> BottomSheetDialog(
                        message = "Repita sua senha!!",
                    ).show(supportFragmentManager, "BottomSheetDialog")
                    /*Toast.makeText(this, "Repita sua senha!!", Toast.LENGTH_SHORT)
                        .show()*/

                    (senha != senha2) -> BottomSheetDialog(
                        message = "As senhas não coincidem",
                    ).show(supportFragmentManager, "BottomSheetDialog")
                    /*Toast.makeText(
                        this,
                        "As senhas não coincidem",
                        Toast.LENGTH_SHORT
                    ).show()*/

                    else -> {
                        FirebaseHelper.criarConta(
                            email, senha,
                            sucesso = { usuario ->
                                BottomSheetDialog(
                                    message = "Registro concluído com sucesso com o email ${usuario?.email}",
                                    onClick = {
                                        finish()
                                    }
                                ).show(supportFragmentManager, "BottomSheetDialog")
                                /*Toast.makeText(
                                    this,
                                    "Registro concluído com sucesso com o email ${usuario?.email}",
                                    Toast.LENGTH_SHORT
                                ).show()*/

                            },
                            falha = { erro ->
                                BottomSheetDialog(
                                    message = "${
                                        if (erro?.message == "The email address is badly formatted."){
                                            "Digite um email com o formato correto."
                                        }else if (erro?.message == "The email address is already in use by another account."){
                                            "Este email não está disponível."
                                        }else{
                                            erro?.message
                                        }
                                    }",

                                ).show(supportFragmentManager, "BottomSheetDialog")
                                /*Toast.makeText(
                                    this,
                                    "Erro no login: ${erro?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()*/
                            })

                    }
                }


            } else {
                BottomSheetDialog(
                    message = "Digite um email!!",

                    ).show(supportFragmentManager, "BottomSheetDialog")
                /*Toast.makeText(this, "Digite um email!!", Toast.LENGTH_SHORT).show()*/
            }
        }
    }
}
