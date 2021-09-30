package com.gilangjs.primordroid.framework.extension

import com.gilangjs.primordroid.domain.model.User
import com.gilangjs.primordroid.framework.local.room.entities.UserEntity

fun UserEntity.toUser(): User {
    return User(id, username, realName)
}
