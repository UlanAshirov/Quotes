package com.example.quotes.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}