package com.alphanication.rebirth.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SchedulersModule {

    @Provides
    @Singleton
    @IoScheduler
    fun providesIoScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Singleton
    @MainScheduler
    fun providesMainScheduler(): Scheduler = AndroidSchedulers.mainThread()
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IoScheduler

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class MainScheduler