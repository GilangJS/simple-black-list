package com.gilangjs.blacklist.framework.extension

import com.gilangjs.blacklist.domain.model.User
import com.gilangjs.blacklist.framework.local.room.entities.UserEntity

fun UserEntity.toUser(): User {
    return User(id, username, realName)
}
