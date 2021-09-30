package com.gilangjs.primordroid.framework.remote

import com.gilangjs.primordroid.data.datasource.IUserDataSource
import com.gilangjs.primordroid.domain.model.User
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(): IUserDataSource {

    override suspend fun getUserList(): Result<List<User>> {
        return Result.success(listOf())
    }
}
