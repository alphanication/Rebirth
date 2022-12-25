package com.example.quotes.data.remote.data_source.quote

import com.example.quotes.data.remote.models.QuoteDto
import io.reactivex.rxjava3.core.Single

interface QuoteDataSource {

    fun getQuote(lang: String): Single<QuoteDto>
}