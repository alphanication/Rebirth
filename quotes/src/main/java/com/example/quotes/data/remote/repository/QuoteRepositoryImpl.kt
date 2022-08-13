package com.example.quotes.data.remote.repository

import com.example.quotes.data.remote.data_source.QuoteDataSource
import com.example.quotes.data.remote.mappers.QuoteMapper
import com.example.quotes.domain.models.Quote
import com.example.quotes.domain.repository.QuoteRepository
import io.reactivex.rxjava3.core.Single

class QuoteRepositoryImpl(private val quoteDataSource: QuoteDataSource) : QuoteRepository {

    override fun getQuote(lang: String): Single<Quote> = quoteDataSource.getQuote(lang = lang).map { QuoteMapper().from(it) }
}