package com.alphanication.rebirth.domain.repository

interface NetworkMonitor {

    fun isConnected(): Boolean
}