package com.example.quotes.domain.repository

interface NetworkMonitor {

    fun isConnected(): Boolean
}