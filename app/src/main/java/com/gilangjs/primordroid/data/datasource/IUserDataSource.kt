package com.gilangjs.primordroid.data.datasource

import com.gilangjs.primordroid.domain.model.User

interface IUserDataSource {
    suspend fun getUserList(): Result<List<User>>
}
