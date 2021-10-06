package com.gilangjs.blacklist.framework.remote

import com.gilangjs.blacklist.data.datasource.IUserDataSource
import com.gilangjs.blacklist.domain.model.User
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(): IUserDataSource {

    override suspend fun getUserList(): Result<List<User>> {
        return Result.success(listOf())
    }
}
