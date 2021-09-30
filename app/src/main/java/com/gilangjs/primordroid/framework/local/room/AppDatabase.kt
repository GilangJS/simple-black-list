package com.gilangjs.primordroid.framework.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gilangjs.primordroid.framework.local.room.dao.UserDao
import com.gilangjs.primordroid.framework.local.room.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
