package com.example.mudea

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mudea.databinding.ActivityLoginBinding
import com.example.mudea.helpers.FirebaseHelper
import com.example.mudea.util.BottomSheetDialog

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createListeners()

    }

    fun createListeners() {
        binding.btnNovaConta.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.btnEsqueceu.setOnClickListener {
            BottomSheetDialog(
                message = "Eu também não sei sua senha!!",
                onClick = {
                    BottomSheetDialog(
                        message = "Zuera mano, recupera sua senha aí kkk",
                        onClick = {
                            val intent = Intent(this, ForgotPasswordActivity::class.java)
                            startActivity(intent)
                        }
                    ).show(supportFragmentManager,"BottomSheetDialog")
                }
            ).show(supportFragmentManager,"BottomSheetDialog")


        }

        binding.enterButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            var email = binding.inputEmail.text.toString()
            var senha = binding.inputPassword.text.toString()
            if (email.isNotEmpty()) {
                if (senha.isNotEmpty()) {
                    FirebaseHelper.logar(
                        email, senha, sucesso = { usuario ->
                            startActivity(intent)
                            finish()
                        },
                        falha = { erro ->
                            /*Toast.makeText(
                                this,
                                "Erro no login: ${erro?.message}",
                                Toast.LENGTH_SHORT
                            ).show()*/
                            BottomSheetDialog(
                                message = "Erro no login: ${erro?.message}",
                            ).show(supportFragmentManager, "BottomSheetDialog")
                        })

                } else {
                    //Toast.makeText(this, "Digite sua senha!!", Toast.LENGTH_SHORT).show()
                    BottomSheetDialog(
                        message = "Digite sua senha!!",
                    ).show(supportFragmentManager, "BottomSheetDialog")
                }
            } else {
                //Toast.makeText(this, "Digite seu email!!", Toast.LENGTH_SHORT).show()
                BottomSheetDialog(
                    message = "Digite seu email!!",
                ).show(supportFragmentManager, "BottomSheetDialog")
            }
        }
    }
}