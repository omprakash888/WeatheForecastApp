package com.example.weatherforecastapp.utils

sealed class ApiStates<out T> {

    data class Success<out R>(val data : R) : ApiStates<R>()
    data class Failure(val msg : Throwable) : ApiStates<Nothing>()
    data object Loading : ApiStates<Nothing>()

    override fun toString(): String {
        return when(this) {
            is Success -> "Success $data"
            is Failure -> "Failure ${msg.message}"
            Loading -> "Loading"
        }
    }
}