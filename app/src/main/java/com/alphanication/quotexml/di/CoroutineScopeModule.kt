package com.alphanication.quotexml.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object CoroutineScopeModule {

    @Provides
    @MainCoroutineScope
    fun providesMainCoroutineScope(
        @MainDispatcher mainDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(mainDispatcher)

    @Provides
    @IOCoroutineScope
    fun providesIoCoroutineScope(
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(ioDispatcher)
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainCoroutineScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IOCoroutineScope