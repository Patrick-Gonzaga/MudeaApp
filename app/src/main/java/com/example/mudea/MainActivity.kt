package com.example.mudea

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mudea.databinding.ActivityLoginBinding
import com.example.mudea.databinding.ActivityMainBinding
import com.example.mudea.fragments.CardsContainerFragment
import com.example.mudea.fragments.PerfilFragment
import com.example.mudea.fragments.PowersFragment
import com.example.mudea.fragments.SettingsFragment
import com.example.mudea.helpers.FirebaseHelper
import com.example.mudea.util.BottomSheetDialog

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


        binding.bottomNavigation.setOnItemSelectedListener { item ->
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
                R.id.navSettings ->{
                    supportFragmentManager.beginTransaction()
                        .replace(binding.navHostFragment.id, SettingsFragment())
                        .commit()
                    true
                }
                R.id.navPerfil ->{
                    supportFragmentManager.beginTransaction()
                        .replace(binding.navHostFragment.id, PerfilFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}