package com.gilangjs.blacklist.presentation.features.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.gilangjs.blacklist.R
import com.gilangjs.blacklist.databinding.MainFragmentBinding
import com.gilangjs.blacklist.presentation.BaseFragment

class MainFragment : BaseFragment() {

    private val viewModel: MainViewModel by viewModels()
    private val binding get() = getBinding<MainFragmentBinding>()

    override fun initBinding(view: View): MainFragmentBinding {
        return MainFragmentBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
