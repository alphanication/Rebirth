package com.example.quotes.ui.quote.mainquote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quotes.ui.base.BaseViewModel
import com.example.quotes.di.IoScheduler
import com.example.quotes.di.MainScheduler
import com.example.quotes.domain.models.Quote
import com.example.quotes.domain.repository.QuoteRepository
import com.example.quotes.ui.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

@HiltViewModel
class MainQuoteVM @Inject constructor(
    @IoScheduler private val ioScheduler: Scheduler,
    @MainScheduler private val mainScheduler: Scheduler,
    private val quoteRepository: QuoteRepository
) : BaseViewModel() {

    private val _quote = MutableLiveData<Quote>()
    val quote: LiveData<Quote> = _quote

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    init {
        getQuote()
    }

    fun getQuote() {
        disposables.plusAssign(
            quoteRepository.getQuote(Constants.LANGUAGE_RU_CODE)
                .subscribeOn(ioScheduler)
                .observeOn(mainScheduler)
                .subscribe({ _quote.postValue(it) }, { _error.postValue(it) })
        )
    }
}