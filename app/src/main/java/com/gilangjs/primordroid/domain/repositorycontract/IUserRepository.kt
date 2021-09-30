package com.gilangjs.primordroid.domain.repositorycontract

import com.gilangjs.primordroid.domain.model.User

interface IUserRepository {

    suspend fun getUsers(): Result<List<User>>
}
