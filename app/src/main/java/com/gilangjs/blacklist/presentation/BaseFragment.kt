package com.gilangjs.blacklist.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment: Fragment() {
    protected var _binding: ViewBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBinding(view)
    }

    private fun setupBinding(view: View) {
        _binding = initBinding(view)
    }

    abstract fun initBinding(view: View): ViewBinding

    protected inline fun <reified T: ViewBinding> getBinding(): T = _binding!! as T

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
