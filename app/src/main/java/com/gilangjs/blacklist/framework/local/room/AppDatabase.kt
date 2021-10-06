package com.gilangjs.blacklist.framework.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gilangjs.blacklist.framework.local.room.dao.UserDao
import com.gilangjs.blacklist.framework.local.room.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}
