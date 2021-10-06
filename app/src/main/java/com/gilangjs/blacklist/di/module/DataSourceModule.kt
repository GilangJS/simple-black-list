package com.gilangjs.blacklist.di.module

import com.gilangjs.blacklist.data.datasource.IUserDataSource
import com.gilangjs.blacklist.di.qualifier.Local
import com.gilangjs.blacklist.di.qualifier.Remote
import com.gilangjs.blacklist.framework.remote.UserRemoteDataSource
import com.gilangjs.blacklist.framework.local.room.UserRoomDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataSourceModule {

    @Provides
    @Singleton
    @Local
    fun provideUserLocalDataSource(userRoomDataSource: UserRoomDataSource): IUserDataSource =
        userRoomDataSource

    @Provides
    @Singleton
    @Remote
    fun provideUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSource): IUserDataSource =
        userRemoteDataSource
}
