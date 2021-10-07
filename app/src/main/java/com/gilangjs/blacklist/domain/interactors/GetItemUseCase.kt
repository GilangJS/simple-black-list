package com.gilangjs.blacklist.domain.interactors

import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.domain.repositorycontract.IItemRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetItemUseCase @Inject constructor(
    private val itemRepository: IItemRepository
): UseCase<String, Item>() {

    override suspend fun run(params: String, scope: CoroutineScope): Result<Item> =
        itemRepository.findItemByLink(params)
}
