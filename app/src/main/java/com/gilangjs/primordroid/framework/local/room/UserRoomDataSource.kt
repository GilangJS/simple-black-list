package com.gilangjs.primordroid.framework.local.room

import com.gilangjs.primordroid.data.datasource.IUserDataSource
import com.gilangjs.primordroid.domain.model.User
import com.gilangjs.primordroid.framework.local.room.dao.UserDao
import com.gilangjs.primordroid.framework.extension.toUser
import javax.inject.Inject

class UserRoomDataSource @Inject constructor(
    private val userDao: UserDao
): IUserDataSource {

    override suspend fun getUserList(): Result<List<User>> {
        return try {
            Result.success(userDao.getAll().map { it.toUser() })
        } catch (t: Throwable) {
            Result.failure(t)
        }
    }
}
