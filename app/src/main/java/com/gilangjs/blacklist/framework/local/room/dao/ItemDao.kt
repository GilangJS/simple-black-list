package com.gilangjs.blacklist.framework.local.room.dao

import androidx.room.*
import com.gilangjs.blacklist.framework.local.room.entities.ItemEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM item")
    fun getAll(): List<ItemEntity>

    @Query("SELECT * FROM item WHERE link = :link")
    fun findByLink(link: String): ItemEntity

    @Query("SELECT * FROM item WHERE hash = :hash")
    fun findByHash(hash: String): ItemEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ItemEntity)

    @Delete
    fun deleteItem(item: ItemEntity)
}
