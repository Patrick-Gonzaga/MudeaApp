package com.example.mudea.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mudea.R
import com.example.mudea.databinding.FragmentCardsContainerBinding
import com.example.mudea.fragments.cardsFragments.AlbumFragment
import com.example.mudea.fragments.cardsFragments.RollsFragment


class CardsContainerFragment : Fragment() {

    private var _binding: FragmentCardsContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardsContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //here
        binding.radioRolls.isChecked = true
        parentFragmentManager.beginTransaction()
            .add(binding.navHostFragmentCards.id, AlbumFragment()).commit()
            .also { binding.radioAlbum.isChecked = true } //APAGAR

        binding.RGRollsAlbum.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                binding.radioRolls.id -> {
                    parentFragmentManager.beginTransaction()
                        .replace(binding.navHostFragmentCards.id, RollsFragment())
                        .commit()

                }
                binding.radioAlbum.id -> {
                    parentFragmentManager.beginTransaction()
                        .replace(binding.navHostFragmentCards.id, AlbumFragment())
                        .commit()

                }
        }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}