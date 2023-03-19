package com.skydoves.core.data.di

import com.skydoves.core.data.repository.DetailRepository
import com.skydoves.core.data.repository.DetailRepositoryImpl
import com.skydoves.core.data.repository.MainRepository
import com.skydoves.core.data.repository.MainRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {

  @Binds
  fun bindsMainRepository(
    mainRepositoryImpl: MainRepositoryImpl
  ): MainRepository

  @Binds
  fun bindsDetailRepository(
    detailRepositoryImpl: DetailRepositoryImpl
  ): DetailRepository
}
