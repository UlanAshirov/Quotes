package com.example.quotes.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.quotes.presentation.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<Binding : ViewBinding, ViewModel : BaseViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: Binding
    protected abstract val viewModel: ViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        constructListeners()
        launchObservers()
    }

    protected open fun initialize() {}

    protected open fun constructListeners() {}

    protected open fun launchObservers() {}

    protected fun <T> StateFlow<UIState<T>>.spectateUiState(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        success: ((data: T) -> Unit)? = null,
        loading: ((data: UIState.Loading<T>) -> Unit)? = null,
        error: ((error: String) -> Unit)? = null,
        idle: ((idle: UIState.Idle<T>) -> Unit)? = null,
        gatherIfSucceed: ((state: UIState<T>) -> Unit)? = null,
    ) {
        safeFlowGather(lifecycleState) {
            collect {
                gatherIfSucceed?.invoke(it)
                when (it) {
                    is UIState.Idle -> idle?.invoke(it)
                    is UIState.Loading -> loading?.invoke(it)
                    is UIState.Error -> error?.invoke(it.msg)
                    is UIState.Success -> success?.invoke(it.data)
                }
            }
        }
    }

    private fun safeFlowGather(
        lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
        gather: suspend () -> Unit,
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(lifecycleState) {
                gather()
            }
        }
    }
}