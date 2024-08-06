package com.example.weatherforecastapp.weather.domain.repository

import com.example.weatherforecastapp.utils.ApiStates
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    suspend fun <T> safeApiCall(
        apiCall : suspend () -> Response<T>
    ) : Result<T> {
        var result : Result<T>

        try {
            val response = apiCall()

            if (response.isSuccessful) {
                val data = response.body()

                if (data != null) {
                    result = Result.success(data)
                }
                else {
                    val error = response.errorBody()?.toString()

                    if (error != null) {
                        result = Result.failure(IOException(error))
                    }
                    else {
                        result = Result.failure(IOException("Something went wrong"))
                    }
                }
            }
            else {
                result =  Result.failure(Throwable(response.errorBody()?.string() ?: "Unknown error"))
            }
        }
        catch (e : Exception) {
            result =  Result.failure(e)
        }

        return result

    }

//    suspend fun <T> safeApiCall(
//        apiCall : suspend () -> Response<T>
//    ) : MutableStateFlow<ApiStates<T>> {
//
//        val result = MutableStateFlow<ApiStates<T>>(ApiStates.Loading)
//
//        try {
//            val response = apiCall()
//
//            if (response.isSuccessful) {
//                val data = response.body()
//
//                if (data != null) {
//                    result.value = ApiStates.Success(data)
//                }
//                else {
//                    val error = response.errorBody()?.toString()
//
//                    if (error != null) {
//                        result.value = ApiStates.Failure(IOException(error))
//                    }
//                    else {
//                        result.value = ApiStates.Failure(IOException("Something went wrong"))
//                    }
//                }
//            }
//            else {
//                result.value = ApiStates.Failure(Throwable(response.errorBody()?.string() ?: "Unknown error"))
//            }
//        }
//        catch (e : Exception) {
//            result.value = ApiStates.Failure(e)
//        }
//
//        return result
//
//    }
}