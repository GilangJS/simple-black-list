package com.gilangjs.blacklist.di.module

import android.content.Context
import androidx.room.Room
import com.gilangjs.blacklist.framework.DB_NAME
import com.gilangjs.blacklist.framework.local.room.AppDatabase
import com.gilangjs.blacklist.framework.local.room.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): ItemDao = appDatabase.userDao()
}
