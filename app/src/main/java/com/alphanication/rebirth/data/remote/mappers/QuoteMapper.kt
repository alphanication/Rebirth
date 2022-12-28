package com.alphanication.rebirth.data.remote.mappers

import com.alphanication.rebirth.data.remote.models.QuoteDto
import com.alphanication.rebirth.data.remote.utils.MapperInterface
import com.alphanication.rebirth.domain.models.Quote
import com.alphanication.rebirth.ui.utils.Constants.EMPTY_STRING

class QuoteMapper : MapperInterface<QuoteDto, Quote> {

    override fun from(i: QuoteDto?): Quote = Quote(
        quoteText = i?.quoteText ?: EMPTY_STRING,
        quoteAuthor = i?.quoteAuthor ?: EMPTY_STRING,
        quoteLink = i?.quoteLink ?: EMPTY_STRING
    )

    override fun to(o: Quote?): QuoteDto = QuoteDto(
        quoteText = o?.quoteText ?: EMPTY_STRING,
        quoteAuthor = o?.quoteAuthor ?: EMPTY_STRING,
        quoteLink = o?.quoteLink ?: EMPTY_STRING,
        senderName = EMPTY_STRING,
        senderLink = EMPTY_STRING
    )
}