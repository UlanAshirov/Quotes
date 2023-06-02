package com.example.quotes.presentation.ui.fragments.board

import android.util.Log
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quotes.R
import com.example.quotes.base.BaseFragmentWithoutViewModel
import com.example.quotes.databinding.FragmentOnBoardBinding
import com.example.quotes.presentation.utils.App

class OnBoardFragment :
    BaseFragmentWithoutViewModel<FragmentOnBoardBinding>(R.layout.fragment_on_board) {
    override val binding: FragmentOnBoardBinding by viewBinding(FragmentOnBoardBinding::bind)

    override fun constructListeners() {
        saveDataInPref()
    }

    private fun saveDataInPref() {
        val list = mutableSetOf<String>()

        binding.rbAlone.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val alone = "alone"
                list.add(alone)
            }
        }
        binding.rbBeauty.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val beauty = "beauty"
                list.add(beauty)
            }
        }
        binding.rbDeath.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val death = "death"
                list.add(death)
            }
        }
        binding.rbFear.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val fear = "fear"
                list.add(fear)
            }
        }
        binding.rbDreams.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val dreams = "dreams"
                list.add(dreams)
            }
        }
        binding.rbFamily.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val family = "family"
                list.add(family)
            }
        }
        binding.rbHealth.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val health = "health"
                list.add(health)
            }
        }
        binding.rbLife.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val life = "life"
                list.add(life)
            }
        }
        binding.rbMoney.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val money = "money"
                list.add(money)
            }
        }
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            App.prefs.saveUserName(name)
            App.prefs.saveUserSettings(list)
            findNavController().navigateUp()
        }
        Log.e("ololo", "${list.size}")
    }
}
