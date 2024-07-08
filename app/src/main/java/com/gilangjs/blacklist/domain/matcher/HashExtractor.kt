package com.gilangjs.blacklist.domain.matcher

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HashExtractor @Inject constructor(){

    fun execute(source: String): String {
        return if (source.startsWith("https://r.grab.com")) {
            getGrabHash(source)
        } else ""
    }

    private fun getGrabHash(source: String): String {
        return source.split('_').last()
    }
}
