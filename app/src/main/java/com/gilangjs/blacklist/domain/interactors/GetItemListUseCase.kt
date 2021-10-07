package com.gilangjs.blacklist.domain.interactors

import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.domain.repositorycontract.IItemRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetItemListUseCase @Inject constructor(
    private val itemRepository: IItemRepository
): UseCase<Unit, List<Item>>() {

    override suspend fun run(params: Unit, scope: CoroutineScope): Result<List<Item>> =
        itemRepository.getItemList()
}
