package com.alphanication.rebirth.di

import com.alphanication.rebirth.data.remote.api.QuoteApiService
import com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSource
import com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSourceImpl
import com.alphanication.rebirth.data.remote.repository.QuoteRepositoryImpl
import com.alphanication.rebirth.domain.repository.QuoteRepository
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