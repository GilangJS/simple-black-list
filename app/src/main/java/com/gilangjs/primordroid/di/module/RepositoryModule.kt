package com.gilangjs.primordroid.di.module

import com.gilangjs.primordroid.data.repository.UserRepository
import com.gilangjs.primordroid.domain.repositorycontract.IUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(userRepository: UserRepository): IUserRepository
}
