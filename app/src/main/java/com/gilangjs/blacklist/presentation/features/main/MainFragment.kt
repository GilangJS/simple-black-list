package com.gilangjs.blacklist.presentation.features.main

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.gilangjs.blacklist.R
import com.gilangjs.blacklist.databinding.MainFragmentBinding
import com.gilangjs.blacklist.presentation.BaseFragment
import com.gilangjs.blacklist.presentation.features.main.MainViewModel.AppState.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewObservers()
        initParam()
    }

    private fun setupViewObservers() {
        viewModel.itemList.observe(viewLifecycleOwner) { items ->
            binding.message.text = items.joinToString(separator = "\n") { it.link }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }

        viewModel.appState.observe(viewLifecycleOwner) {
            if (it == SHOW_ITEM) binding.message.visibility = View.VISIBLE
            else binding.message.visibility = View.GONE

            when (it) {
                DELETE_ITEM -> {
                }
                SAVE_ITEM -> {
                    AlertDialog.Builder(requireContext())
                        .setCancelable(false)
                        .setTitle("Save Item?")
                        .setMessage(viewModel.currentItem.value?.link ?: "null")
                        .setPositiveButton("Save") { dialog, id ->
                            viewModel.saveCurrentItem()
                        }
                        .setNegativeButton("Cancel") { dialog, id ->
                            viewModel.cancelSelectItem()
                            dialog.dismiss()
                        }.create().show()
                }
                ITEM_EXIST -> {
                    Toast.makeText(requireContext(), "Item is in blacklist", Toast.LENGTH_LONG)
                        .show()
                    viewModel.loadData()
                }
                else -> {
                }
            }
        }
    }

    private fun initParam() {
        val param = arguments?.getString(PARAM)
        if (param == null) viewModel.loadData()
        else viewModel.setParam(param)
    }

    fun setParam(param: String?) {
        viewModel.setParam(param)
    }

    companion object {
        fun newInstance(param: String?): MainFragment {
            val args = Bundle().apply { putString(PARAM, param) }
            return MainFragment().apply { arguments = args }
        }

        private const val PARAM = "param"
    }
}
