package com.alphanication.rebirth.data.remote.repository

import com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSource
import com.alphanication.rebirth.data.remote.mappers.QuoteMapper
import com.alphanication.rebirth.domain.models.Quote
import com.alphanication.rebirth.domain.repository.QuoteRepository
import io.reactivex.rxjava3.core.Single

class QuoteRepositoryImpl(
    private val quoteDataSource: QuoteDataSource
) : QuoteRepository {

    override fun getQuote(lang: String): Single<Quote> =
        quoteDataSource.getQuote(lang = lang).map { QuoteMapper().from(it) }
}