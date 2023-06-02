package com.example.quotes.data.repository

import com.example.quotes.common.Resource
import com.example.quotes.data.service.QuoteApiService
import com.example.quotes.domain.model.quote.QuoteModel
import com.example.quotes.domain.repository.QuoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class QuoteRepositoryImpl(private val apiService: QuoteApiService) : QuoteRepository {

    override fun getQuote(category: String): Flow<Resource<List<QuoteModel>>> = flow {
        try {
            emit(Resource.Loading())
            val result = apiService.getQuote(category = category).map { it.toDomain() }
            emit(Resource.Success(data = result))
        } catch (e: java.lang.Exception) {
            emit(Resource.Error(message = "$e"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "$e"))
        }
    }
}