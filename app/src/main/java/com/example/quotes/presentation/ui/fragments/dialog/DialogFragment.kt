package com.example.quotes.presentation.ui.fragments.dialog

import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quotes.R
import com.example.quotes.base.DialogBaseFragment
import com.example.quotes.databinding.FragmentDialogBinding
import com.example.quotes.presentation.utils.App
import org.koin.androidx.viewmodel.ext.android.viewModel

class DialogFragment :
    DialogBaseFragment<FragmentDialogBinding, DialogViewModel>(R.layout.fragment_dialog) {
    override val binding: FragmentDialogBinding by viewBinding(FragmentDialogBinding::bind)
    override val viewModel: DialogViewModel by viewModel()

    override fun initialize() {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.dialog_rounded_bg)
        if (App.prefs.getUserSettings() != null && App.prefs.getUserSettings()
                ?.isNotEmpty() == true
        ) {
            Log.e("ololo", "${App.prefs.getUserSettings()}")
            Log.e("ololo", "${App.prefs.getUserName()}")
            val list = App.prefs.getUserSettings()?.toList()!!
            val randomIndex = (list.indices).random()
            val category = list[randomIndex]

            viewModel.getQuote(category)
        } else {
            findNavController().navigate(R.id.onBoardFragment)
        }
    }

    override fun launchObservers() {
        viewModel.quoteState.spectateUiState(success = { quote ->
            val quoteText = quote[0]
            binding.tvTitleQuote.text = quoteText.category
            binding.tvQuoteAuthor.text = quoteText.author
            viewModel.getTranslateText(quoteText.quote)
        }, loading = {
            Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
        }, error = { error ->
            Log.e("ololo", error)
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        })

        viewModel.translateState.spectateUiState(success = { translateText ->
            binding.tvQuote.text = translateText[0].translatedText
        }, loading = {
            Toast.makeText(requireContext(), "LoadingTranslate", Toast.LENGTH_SHORT).show()
        }, error = { error ->
            Log.e("ololo", error)
        })

        binding.btnOk.setOnClickListener {
            dismiss()
        }
    }
}