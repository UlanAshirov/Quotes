package com.example.quotes.data.dto.quote

import com.example.quotes.data.mapper.DataMapper
import com.example.quotes.domain.model.quote.QuoteModel
import com.google.gson.annotations.SerializedName

data class QuoteResponseItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("quote")
    val quote: String
) : DataMapper<QuoteModel> {
    override fun toDomain() = QuoteModel(
        author = author,
        category = category,
        quote = quote
    )
}