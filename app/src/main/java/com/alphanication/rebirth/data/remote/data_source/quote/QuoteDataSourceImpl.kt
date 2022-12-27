package com.alphanication.rebirth.data.remote.data_source.quote

import com.alphanication.rebirth.data.remote.api.QuoteApiService
import com.alphanication.rebirth.data.remote.data_source.quote.QuoteDataSource
import com.alphanication.rebirth.data.remote.models.QuoteDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteDataSourceImpl @Inject constructor(
    private val quoteApiService: QuoteApiService
) : QuoteDataSource {

    override fun getQuote(lang: String): Single<QuoteDto> = quoteApiService.getQuote(lang = lang)
}