package com.example.quotes.ui.mainquote

import com.example.quotes.base.ui.BaseViewModel
import com.example.quotes.domain.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainQuoteVM @Inject constructor(
    private val quoteRepository: QuoteRepository
) : BaseViewModel() {

}