package com.example.quotes.base.ui

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    protected var disposables: CompositeDisposable = CompositeDisposable()

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        disposables.apply {
            this.clear()
        }
        super.onCleared()
    }
}