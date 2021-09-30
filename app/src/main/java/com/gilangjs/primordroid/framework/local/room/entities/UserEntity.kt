package com.gilangjs.primordroid.framework.local.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    @ColumnInfo(name = "real_name") val realName: String
)
