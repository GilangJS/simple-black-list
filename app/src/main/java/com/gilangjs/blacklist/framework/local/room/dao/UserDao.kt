package com.gilangjs.blacklist.framework.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.gilangjs.blacklist.framework.local.room.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>
}
