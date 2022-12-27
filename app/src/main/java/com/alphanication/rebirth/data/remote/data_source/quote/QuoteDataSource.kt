package com.alphanication.rebirth.data.remote.data_source.quote

import com.alphanication.rebirth.data.remote.models.QuoteDto
import io.reactivex.rxjava3.core.Single

interface QuoteDataSource {

    fun getQuote(lang: String): Single<QuoteDto>
}