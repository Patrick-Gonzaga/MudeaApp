package com.example.mudea.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.isVisible
import com.example.mudea.R
import com.example.mudea.databinding.ActivityMainBinding
import com.example.mudea.fragments.CardsContainerFragment
import com.example.mudea.fragments.PerfilFragment
import com.example.mudea.fragments.PowersFragment
import com.example.mudea.fragments.UsersFragment
import com.example.mudea.helpers.FirebaseHelper
import com.example.mudea.util.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BottomSheetDialog(
            message = "Login concluído com email: ${FirebaseHelper.getUser()?.email}",
        ).show(supportFragmentManager, "BottomSheetDialog")
        initFragment()

    }

    fun initFragment(){
        supportFragmentManager.beginTransaction()
            .add(binding.navHostFragment.id, PowersFragment()).commit()

        with(binding){
            bottomNavigation.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navCard -> {
                        supportFragmentManager.beginTransaction()
                            .replace(binding.navHostFragment.id, CardsContainerFragment())
                            .commit()
                        true
                    }
                    R.id.navPowers ->{
                        supportFragmentManager.beginTransaction()
                            .replace(binding.navHostFragment.id, PowersFragment())
                            .commit()
                        true
                    }
                    R.id.navUsers ->{
                        supportFragmentManager.beginTransaction()
                            .replace(binding.navHostFragment.id, UsersFragment())
                            .commit()
                        true
                    }

                    else -> false
                }
            }
            fabMain.setOnClickListener {
                if(fabGroup.isVisible){
                    fabGroup.visibility = View.GONE
                }else{
                    fabGroup.visibility = View.VISIBLE
                    fabLogout.setOnClickListener {
                        BottomSheetDialog(
                            title = "Logout",
                            message = "Tem certeza que quer sair?",
                            button = "Sim, quero sair",
                            onClick = {
                                FirebaseHelper.signOut()
                                val intent = Intent(applicationContext, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        ).show(supportFragmentManager, "BottomSheetLogout")
                    }
                    fabPerfil.setOnClickListener {
                        supportFragmentManager.beginTransaction()
                            .replace(navHostFragment.id, PerfilFragment())
                            .commit()

                        // Desativa temporariamente a seleção automática
                        binding.bottomNavigation.menu.setGroupCheckable(0, false, false)

                        // Desmarca todos os itens manualmente
                        for (i in 0 until binding.bottomNavigation.menu.size()) {
                            binding.bottomNavigation.menu.getItem(i).isChecked = false
                        }

                        binding.bottomNavigation.menu.setGroupCheckable(0, true, true)


                    }

                }
            }
        }

    }
}