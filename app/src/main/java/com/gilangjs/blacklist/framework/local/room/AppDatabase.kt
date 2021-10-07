package com.gilangjs.blacklist.framework.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gilangjs.blacklist.framework.local.room.dao.ItemDao
import com.gilangjs.blacklist.framework.local.room.entities.ItemEntity

@Database(entities = [ItemEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): ItemDao
}
