package com.gilangjs.blacklist.data.repository

import com.gilangjs.blacklist.data.datasource.IUserDataSource
import com.gilangjs.blacklist.di.qualifier.Local
import com.gilangjs.blacklist.di.qualifier.Remote
import com.gilangjs.blacklist.domain.model.User
import com.gilangjs.blacklist.domain.repositorycontract.IUserRepository
import javax.inject.Inject

class UserRepository @Inject constructor(
    @Remote private val networkDataSource: IUserDataSource,
    @Local private val localDataSource: IUserDataSource
): IUserRepository {

    override suspend fun getUsers(): Result<List<User>> {
        val localData = localDataSource.getUserList()
        val networkData = networkDataSource.getUserList()

        return if (networkData.isSuccess) networkData
        else localData
    }
}
