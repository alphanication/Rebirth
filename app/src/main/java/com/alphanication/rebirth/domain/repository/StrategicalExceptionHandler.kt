package com.alphanication.rebirth.domain.repository

import com.alphanication.rebirth.ui.utils.StrategicalExceptions

interface StrategicalExceptionHandler {

    fun onError(exception: (StrategicalExceptions) -> Unit)
}