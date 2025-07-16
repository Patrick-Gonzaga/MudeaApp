package com.example.mudea.util

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mudea.R
import com.example.mudea.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetDialog(
    private val title: String? = "Atenção",
    private val message: String,
    private val button: String? = "Entendi",
    private val onClick: () -> Unit = {}
) : BottomSheetDialogFragment(){
    private var _binding : BottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomSheetDialogBinding.inflate(inflater,container,false)
        binding.bottomSheetTitle.text = title
        binding.bottomSheetMessage.text = message
        binding.bottomSheetButton.text = button

        binding.bottomSheetButton.setOnClickListener {
            onClick()
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}