package com.gilangjs.blacklist.di.module

import com.gilangjs.blacklist.data.repository.ItemRepository
import com.gilangjs.blacklist.domain.repositorycontract.IItemRepository
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
    abstract fun bindUserRepository(itemRepository: ItemRepository): IItemRepository
}
