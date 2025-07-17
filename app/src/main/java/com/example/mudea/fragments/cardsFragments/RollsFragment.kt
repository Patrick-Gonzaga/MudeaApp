package com.example.mudea.fragments.cardsFragments

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.mudea.R
import com.example.mudea.databinding.FragmentRollsBinding
import jp.wasabeef.blurry.Blurry

class RollsFragment : Fragment() {

    private var _binding: FragmentRollsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRollsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //here
        /*initShadowBlur()*/

    }


    /*fun initShadowBlur(){
        val viewToBlur = requireView().findViewById<View>(R.id.cardView)
        viewToBlur.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(viewToBlur.drawingCache)
        viewToBlur.isDrawingCacheEnabled = false
        Blurry.with(requireContext())
            .radius(15)
            .from(bitmap)
            .into(requireView().findViewById(R.id.shadowBg))
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}