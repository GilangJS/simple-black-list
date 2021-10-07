package com.gilangjs.blacklist.domain.interactors

import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.domain.repositorycontract.IItemRepository
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class SaveItemUseCase @Inject constructor(
    private val itemRepository: IItemRepository
): UseCase<Item, Unit>() {

    override suspend fun run(params: Item, scope: CoroutineScope): Result<Unit> =
        itemRepository.saveItem(params)
}
