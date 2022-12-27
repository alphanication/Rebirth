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
    fun providesQuoteDataSource(quoteApiService: com.alphanication.rebirth.data.remote.api.QuoteApiService): com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSource =
        com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSourceImpl(quoteApiService = quoteApiService)

    @Provides
    @Singleton
    fun providesQuoteRepository(quoteDataSource: com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSource): QuoteRepository =
        com.alphanication.rebirth.data.remote.repository.QuoteRepositoryImpl(quoteDataSource = quoteDataSource)
}