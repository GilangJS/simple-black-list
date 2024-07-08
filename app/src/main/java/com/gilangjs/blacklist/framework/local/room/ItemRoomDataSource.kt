package com.gilangjs.blacklist.framework.local.room

import com.gilangjs.blacklist.data.datasource.IItemDataSource
import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.framework.extension.toItem
import com.gilangjs.blacklist.framework.extension.toItemEntity
import com.gilangjs.blacklist.framework.local.room.dao.ItemDao
import javax.inject.Inject

class ItemRoomDataSource @Inject constructor(
    private val itemDao: ItemDao
): IItemDataSource {

    override suspend fun getItemList(): Result<List<Item>> {
        return try {
            Result.success(itemDao.getAll().map { it.toItem() })
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun findItemByLink(link: String): Result<Item> {
        return try {
            Result.success(itemDao.findByLink(link).toItem())
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun findItemByHash(hash: String): Result<Item> {
        return try {
            Result.success(itemDao.findByHash(hash).toItem())
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun deleteItem(item: Item): Result<Unit> {
        return try {
            Result.success(itemDao.deleteItem(item.toItemEntity()))
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun saveItem(item: Item): Result<Unit> {
        return try {
            Result.success(itemDao.insertItem(item.toItemEntity()))
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}
