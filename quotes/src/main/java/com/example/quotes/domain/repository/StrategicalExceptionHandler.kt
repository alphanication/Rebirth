package com.example.quotes.domain.repository

import com.example.quotes.ui.utils.StrategicalExceptions

interface StrategicalExceptionHandler {

    fun onError(exception: (StrategicalExceptions) -> Unit)
}