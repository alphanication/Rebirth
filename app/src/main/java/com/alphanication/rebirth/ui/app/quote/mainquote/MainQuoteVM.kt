package com.alphanication.rebirth.ui.app.quote.mainquote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alphanication.rebirth.ui.base.BaseViewModel
import com.alphanication.rebirth.di.IoScheduler
import com.alphanication.rebirth.di.MainScheduler
import com.alphanication.rebirth.domain.models.Quote
import com.alphanication.rebirth.domain.repository.QuoteRepository
import com.alphanication.rebirth.ui.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

@HiltViewModel
class MainQuoteVM @Inject constructor(
    @com.alphanication.rebirth.di.IoScheduler private val ioScheduler: Scheduler,
    @com.alphanication.rebirth.di.MainScheduler private val mainScheduler: Scheduler,
    private val quoteRepository: com.alphanication.rebirth.domain.repository.QuoteRepository
) : BaseViewModel() {

    private val _quote = MutableLiveData<com.alphanication.rebirth.domain.models.Quote>()
    val quote: LiveData<com.alphanication.rebirth.domain.models.Quote> = _quote

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