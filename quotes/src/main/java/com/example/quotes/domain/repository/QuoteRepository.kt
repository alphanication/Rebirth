package com.example.quotes.domain.repository

import com.example.quotes.domain.models.Quote
import io.reactivex.rxjava3.core.Single

interface QuoteRepository {

    fun getQuote(lang: String): Single<Quote>
}