package com.gilangjs.blacklist.framework.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class ItemEntity(
    @PrimaryKey val link: String,
    val source: String?
)
