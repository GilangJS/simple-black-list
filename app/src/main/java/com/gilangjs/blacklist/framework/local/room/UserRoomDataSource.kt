package com.gilangjs.blacklist.framework.local.room

import com.gilangjs.blacklist.data.datasource.IUserDataSource
import com.gilangjs.blacklist.domain.model.User
import com.gilangjs.blacklist.framework.local.room.dao.UserDao
import com.gilangjs.blacklist.framework.extension.toUser
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
