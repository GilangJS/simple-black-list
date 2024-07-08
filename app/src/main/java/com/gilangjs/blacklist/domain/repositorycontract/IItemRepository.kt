package com.gilangjs.blacklist.domain.repositorycontract

import com.gilangjs.blacklist.domain.model.Item

interface IItemRepository {

    suspend fun getItemList(): Result<List<Item>>

    suspend fun findItemByLink(link: String): Result<Item>

    suspend fun findItemByHash(hash: String): Result<Item>

    suspend fun deleteItem(item: Item): Result<Unit>

    suspend fun saveItem(item: Item): Result<Unit>
}
