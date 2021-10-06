package com.gilangjs.blacklist.di.module

import com.gilangjs.blacklist.data.repository.UserRepository
import com.gilangjs.blacklist.domain.repositorycontract.IUserRepository
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
