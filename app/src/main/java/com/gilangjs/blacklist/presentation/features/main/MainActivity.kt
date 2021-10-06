package com.gilangjs.blacklist.presentation.features.main

import android.content.Intent
import android.os.Bundle
import com.gilangjs.blacklist.R
import com.gilangjs.blacklist.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val action = intent.action
        val type = intent.type

        val param = if (action == Intent.ACTION_SEND && type == "text/plain") {
            intent.getStringExtra(Intent.EXTRA_TEXT)
        } else null
        addFragment(savedInstanceState, param)
    }

    private fun addFragment(savedInstanceState: Bundle?, param: String?) {
        val existingFragment =
            supportFragmentManager.findFragmentByTag(MAIN_FRAGMENT_TAG) as? MainFragment
        if (savedInstanceState == null || existingFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance(param), MAIN_FRAGMENT_TAG)
                .commitNow()
        } else {
            existingFragment.setParam(param)
        }
    }

    companion object {
        private const val MAIN_FRAGMENT_TAG = "mainFragment"
    }
}
