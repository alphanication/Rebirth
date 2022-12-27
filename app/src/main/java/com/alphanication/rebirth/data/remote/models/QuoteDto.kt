package com.alphanication.rebirth.data.remote.models

import com.alphanication.rebirth.data.remote.utils.DataURLConstants.QUOTE_AUTHOR_FIELD
import com.alphanication.rebirth.data.remote.utils.DataURLConstants.QUOTE_LINK_FIELD
import com.alphanication.rebirth.data.remote.utils.DataURLConstants.QUOTE_TEXT_FIELD
import com.alphanication.rebirth.data.remote.utils.DataURLConstants.SENDER_LINK_FIELD
import com.alphanication.rebirth.data.remote.utils.DataURLConstants.SENDER_NAME_FIELD
import com.google.gson.annotations.SerializedName

data class QuoteDto(
    @SerializedName(QUOTE_TEXT_FIELD) val quoteText: String?,
    @SerializedName(QUOTE_AUTHOR_FIELD) val quoteAuthor: String?,
    @SerializedName(SENDER_NAME_FIELD) val senderName: String?,
    @SerializedName(SENDER_LINK_FIELD) val senderLink: String?,
    @SerializedName(QUOTE_LINK_FIELD) val quoteLink: String?
)