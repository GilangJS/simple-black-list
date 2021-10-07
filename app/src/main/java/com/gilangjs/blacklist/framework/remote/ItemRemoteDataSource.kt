package com.gilangjs.blacklist.framework.remote

import com.gilangjs.blacklist.data.datasource.IItemDataSource
import com.gilangjs.blacklist.domain.model.Item
import javax.inject.Inject

class ItemRemoteDataSource @Inject constructor(): IItemDataSource {

    override suspend fun getItemList(): Result<List<Item>> {
        return Result.success(listOf())
    }

    override suspend fun findItemByLink(link: String): Result<Item> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(item: Item): Result<Unit> {
        TODO("Not yet implemented")
    }

    override suspend fun saveItem(item: Item): Result<Unit> {
        TODO("Not yet implemented")
    }
}
