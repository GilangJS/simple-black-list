package com.gilangjs.blacklist.framework.extension

import com.gilangjs.blacklist.domain.model.Item
import com.gilangjs.blacklist.framework.local.room.entities.ItemEntity

fun ItemEntity.toItem(): Item {
    return Item(link, source)
}

fun Item.toItemEntity(): ItemEntity {
    return ItemEntity(link, source)
}
