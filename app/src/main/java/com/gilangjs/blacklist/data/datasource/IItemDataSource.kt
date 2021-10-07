package com.gilangjs.blacklist.data.datasource

import com.gilangjs.blacklist.domain.model.Item

interface IItemDataSource {
    suspend fun getItemList(): Result<List<Item>>

    suspend fun findItemByLink(link: String): Result<Item>

    suspend fun deleteItem(item: Item): Result<Unit>

    suspend fun saveItem(item: Item): Result<Unit>
}
