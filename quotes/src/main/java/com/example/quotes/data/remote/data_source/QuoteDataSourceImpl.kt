package com.example.quotes.data.remote.data_source

import com.example.quotes.data.remote.api.QuoteApiService
import com.example.quotes.data.remote.models.QuoteDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class QuoteDataSourceImpl @Inject constructor(
    private val quoteApiService: QuoteApiService
) : QuoteDataSource {

    override fun getQuote(lang: String): Single<QuoteDto> = quoteApiService.getQuote(lang = lang)
}