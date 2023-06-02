package com.example.quotes.data.repository

import com.example.quotes.common.Resource
import com.example.quotes.data.service.TranslateApiService
import com.example.quotes.domain.model.translate.TranslationModel
import com.example.quotes.domain.repository.TranslateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class TranslateRepositoryImpl(
    private val apiTranslate: TranslateApiService
) : TranslateRepository {
    override fun getTranslateText(translateText: String): Flow<Resource<List<TranslationModel>>> =
        flow {
            try {
                emit(Resource.Loading())
                val result =
                    apiTranslate.getTranslateText(translateText = translateText).data.translations.map { it.toDomain() }
                emit(Resource.Success(result))
            } catch (e: java.lang.Exception) {
                emit(Resource.Error(message = "$e"))
            } catch (e: IOException) {
                emit(Resource.Error(message = "$e"))
            }
        }
}