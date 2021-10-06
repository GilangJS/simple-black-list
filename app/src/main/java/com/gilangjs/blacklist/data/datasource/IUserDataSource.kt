package com.gilangjs.blacklist.data.datasource

import com.gilangjs.blacklist.domain.model.User

interface IUserDataSource {
    suspend fun getUserList(): Result<List<User>>
}
