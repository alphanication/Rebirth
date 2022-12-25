package com.example.quotes.data.remote.utils

interface MapperInterface<I, O> {

    fun from(i: I?): O

    fun to(o: O?): I
}