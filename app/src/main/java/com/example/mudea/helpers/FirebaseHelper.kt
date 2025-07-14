package com.example.mudea.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser



object FirebaseHelper {


    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getUser(): FirebaseUser? {
        return auth.currentUser
    }

    fun isLogged(): Boolean  {
        return getUser() != null
    }

    fun signOut(){
        auth.signOut()
    }

    fun criarConta(
        email: String,
        senha: String,
        sucesso: (FirebaseUser?) -> Unit,
        falha: (Exception?) -> Unit
    ){
        auth.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { resultado ->
                sucesso(resultado.user)
            }
            .addOnFailureListener { erro ->
                falha(erro)
            }
    }

    fun logar(
        email: String,
        senha: String,
        sucesso: (FirebaseUser?) -> Unit,
        falha: (Exception?) -> Unit
    ){
        auth.signInWithEmailAndPassword(email, senha)
            .addOnSuccessListener { resultado ->
                sucesso(resultado.user)
            }
            .addOnFailureListener { erro ->
                falha(erro)
            }
    }

    fun recuperarSenha(
        email: String,
        sucesso: () -> Unit,
        falha: (Exception?) -> Unit
    ){
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                sucesso()
            }
            .addOnFailureListener { erro ->
                falha(erro)

            }
    }


}