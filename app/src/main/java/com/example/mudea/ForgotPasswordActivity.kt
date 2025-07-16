package com.example.mudea

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mudea.databinding.ActivityForgotPasswordBinding
import com.example.mudea.helpers.FirebaseHelper
import com.example.mudea.util.BottomSheetDialog

class ForgotPasswordActivity : AppCompatActivity() {

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
                        BottomSheetDialog(
                            message = "O código foi enviado para o seu email!!",
                            onClick = {
                                finish()
                            }
                        ).show(supportFragmentManager, "BottomSheetDialog")
                        /*Toast.makeText(this,
                            "O código foi enviado para o seu email!!",
                            Toast.LENGTH_SHORT
                        ).show()*/

                    },
                    falha = {
                        erro ->
                        BottomSheetDialog(
                            message = "Ocorreu um erro: ${erro?.message}",
                        ).show(supportFragmentManager, "BottomSheetDialog")
                        /*Toast.makeText(this,
                            "Ocorreu um erro: ${erro?.message}",
                            Toast.LENGTH_SHORT
                        ).show()*/
                    }
                )
            }else{
                BottomSheetDialog(
                    message = "Digite um email!!",
                ).show(supportFragmentManager, "BottomSheetDialog")
                /*Toast.makeText(this, "Digite um email!!", Toast.LENGTH_SHORT).show()*/
            }
        }
    }
}