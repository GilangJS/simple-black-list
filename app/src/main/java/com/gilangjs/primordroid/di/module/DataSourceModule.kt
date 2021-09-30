package com.gilangjs.primordroid.di.module

import com.gilangjs.primordroid.data.datasource.IUserDataSource
import com.gilangjs.primordroid.di.qualifier.Local
import com.gilangjs.primordroid.di.qualifier.Remote
import com.gilangjs.primordroid.framework.remote.UserRemoteDataSource
import com.gilangjs.primordroid.framework.local.room.UserRoomDataSource
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
