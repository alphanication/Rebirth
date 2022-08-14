package com.example.quotes.di

import com.example.quotes.data.remote.api.QuoteApiService
import com.example.quotes.data.remote.data_source.QuoteDataSource
import com.example.quotes.data.remote.data_source.QuoteDataSourceImpl
import com.example.quotes.data.remote.repository.QuoteRepositoryImpl
import com.example.quotes.domain.repository.QuoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesQuoteDataSource(quoteApiService: QuoteApiService): QuoteDataSource =
        QuoteDataSourceImpl(quoteApiService = quoteApiService)

    @Provides
    @Singleton
    fun providesQuoteRepository(quoteDataSource: QuoteDataSource): QuoteRepository =
        QuoteRepositoryImpl(quoteDataSource = quoteDataSource)
}