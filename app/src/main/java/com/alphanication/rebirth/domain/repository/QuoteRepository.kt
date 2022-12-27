package com.alphanication.rebirth.domain.repository

import com.alphanication.rebirth.domain.models.Quote
import io.reactivex.rxjava3.core.Single

interface QuoteRepository {

    fun getQuote(lang: String): Single<Quote>
}