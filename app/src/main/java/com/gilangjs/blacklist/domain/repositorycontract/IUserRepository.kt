package com.gilangjs.blacklist.domain.repositorycontract

import com.gilangjs.blacklist.domain.model.User

interface IUserRepository {

    suspend fun getUsers(): Result<List<User>>
}
