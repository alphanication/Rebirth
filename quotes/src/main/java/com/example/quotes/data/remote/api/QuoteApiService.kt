package com.example.quotes.data.remote.api

import com.example.quotes.data.remote.models.QuoteDto
import com.example.quotes.data.remote.utils.DataURLConstants.QUOTE_FORMAT_ACTUAL_FIELD
import com.example.quotes.data.remote.utils.DataURLConstants.QUOTE_FORMAT_FIELD
import com.example.quotes.data.remote.utils.DataURLConstants.QUOTE_LANG_FIELD
import com.example.quotes.data.remote.utils.DataURLConstants.QUOTE_METHOD_ACTUAL_FIELD
import com.example.quotes.data.remote.utils.DataURLConstants.QUOTE_METHOD_FIELD
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface QuoteApiService {

    /* lang: on documentation (https://forismatic.com/api/) - en / ru
     * Vorobey Egor / 14.08.2022 */

    @POST("1.0/")
    @FormUrlEncoded
    fun getQuote(
        @Field(QUOTE_METHOD_FIELD) method: String = QUOTE_METHOD_ACTUAL_FIELD,
        @Field(QUOTE_FORMAT_FIELD) format: String = QUOTE_FORMAT_ACTUAL_FIELD,
        @Field(QUOTE_LANG_FIELD) lang: String
    ): Single<QuoteDto>

    companion object {
        const val BASE_URL = "http://api.forismatic.com/api/"
    }
}