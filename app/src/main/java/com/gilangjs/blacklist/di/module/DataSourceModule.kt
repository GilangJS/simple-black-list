package com.gilangjs.blacklist.di.module

import com.gilangjs.blacklist.data.datasource.IItemDataSource
import com.gilangjs.blacklist.di.qualifier.Local
import com.gilangjs.blacklist.framework.local.room.ItemRoomDataSource
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
    fun provideItemLocalDataSource(itemRoomDataSource: ItemRoomDataSource): IItemDataSource =
        itemRoomDataSource
}
