package com.example.quotes.base.ui

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    private var disposables: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        disposables.apply {
            this.clear()
        }
        super.onCleared()
    }
}