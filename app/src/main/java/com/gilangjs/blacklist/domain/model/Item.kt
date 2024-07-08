package com.gilangjs.blacklist.domain.model

data class Item (
    val link: String,
    val hash: String,
    val source: String? = null,
)
