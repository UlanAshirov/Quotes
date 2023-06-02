package com.example.quotes.presentation.ui.fragments.main

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quotes.R
import com.example.quotes.base.BaseFragmentWithoutViewModel
import com.example.quotes.databinding.FragmentMainBinding
import com.example.quotes.presentation.utils.App

class MainFragment : BaseFragmentWithoutViewModel<FragmentMainBinding>(R.layout.fragment_main) {
    override val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)

    override fun initialize() {
        binding.tvUserName.text = "Добро пожаловать ${App.prefs.getUserName()}"
        findNavController().navigate(R.id.dialogFragment)
    }

    override fun constructListeners() {
        binding.btnLogOut.setOnClickListener {
            App.prefs.clearData()
        }
    }
}
