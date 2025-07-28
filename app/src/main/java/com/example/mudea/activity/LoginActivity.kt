package com.example.mudea.activity

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
        isLogged()
        createListeners()
    }

    fun isLogged(){
        if (FirebaseHelper.isLogged()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    fun createListeners() {
        val intentLog = Intent(this, MainActivity::class.java)
        val intentReg = Intent(this, RegisterActivity::class.java)
        val intentForg = Intent(this, ForgotPasswordActivity::class.java)
        with(binding){
            enterButton.setOnClickListener {
                var email = binding.inputEmail.text.toString()
                var senha = binding.inputPassword.text.toString()
                if (email.isNotEmpty()) {
                    if (senha.isNotEmpty()) {
                        FirebaseHelper.logar(
                            email, senha, sucesso = { usuario ->
                                startActivity(intentLog)
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
            btnNovaConta.setOnClickListener {
                startActivity(intentReg)
            }
            btnEsqueceu.setOnClickListener {
                BottomSheetDialog(
                    message = "Eu também não sei sua senha!!",
                    onClick = {
                        BottomSheetDialog(
                            message = "Zuera mano, recupera sua senha aí kkk",
                            onClick = {
                                startActivity(intentForg)
                            }
                        ).show(supportFragmentManager,"BottomSheetDialog")
                    }
                ).show(supportFragmentManager,"BottomSheetDialog")


            }
        }


    }
}