package com.gilangjs.blacklist.data.repository

import com.gilangjs.blacklist.data.datasource.IItemDataSource
import com.gilangjs.blacklist.di.qualifier.Local
import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.domain.repositorycontract.IItemRepository
import javax.inject.Inject

class ItemRepository @Inject constructor(
    @Local private val dataSource: IItemDataSource
) : IItemRepository {

    override suspend fun getItemList(): Result<List<Item>> = dataSource.getItemList()

    override suspend fun findItemByLink(link: String): Result<Item> =
        dataSource.findItemByLink(link)

    override suspend fun findItemByHash(hash: String): Result<Item> =
        dataSource.findItemByHash(hash)

    override suspend fun deleteItem(item: Item): Result<Unit> {
        return try {
            dataSource.deleteItem(item)
            Result.success(Unit)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }

    override suspend fun saveItem(item: Item): Result<Unit> {
        return try {
            dataSource.saveItem(item)
            Result.success(Unit)
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}
