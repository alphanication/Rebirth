package com.example.quotes.data.remote.mappers

import com.example.quotes.data.remote.models.QuoteDto
import com.example.quotes.data.remote.utils.DataURLConstants.EMPTY_STR
import com.example.quotes.data.remote.utils.MapperInterface
import com.example.quotes.domain.models.Quote

class QuoteMapper : MapperInterface<QuoteDto, Quote> {

    override fun from(i: QuoteDto?): Quote = Quote(
        quoteText = i?.quoteText ?: EMPTY_STR,
        quoteAuthor = i?.quoteAuthor ?: EMPTY_STR,
        quoteLink = i?.quoteLink ?: EMPTY_STR
    )

    override fun to(o: Quote?): QuoteDto = QuoteDto(
        quoteText = o?.quoteText ?: EMPTY_STR,
        quoteAuthor = o?.quoteAuthor ?: EMPTY_STR,
        quoteLink = o?.quoteLink ?: EMPTY_STR,
        senderName = EMPTY_STR,
        senderLink = EMPTY_STR
    )
}