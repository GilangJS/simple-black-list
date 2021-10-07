package com.gilangjs.blacklist.framework.local.room.dao

import androidx.room.*
import com.gilangjs.blacklist.framework.local.room.entities.ItemEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getAll(): List<ItemEntity>

    @Query("SELECT * FROM item WHERE link = :link")
    fun findByLink(link: String): ItemEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)
}
