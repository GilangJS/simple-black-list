package com.gilangjs.primordroid.framework.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.gilangjs.primordroid.framework.local.room.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>
}
