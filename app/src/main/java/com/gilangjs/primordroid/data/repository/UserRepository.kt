package com.gilangjs.primordroid.data.repository

import com.gilangjs.primordroid.data.datasource.IUserDataSource
import com.gilangjs.primordroid.di.qualifier.Local
import com.gilangjs.primordroid.di.qualifier.Remote
import com.gilangjs.primordroid.domain.model.User
import com.gilangjs.primordroid.domain.repositorycontract.IUserRepository
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
