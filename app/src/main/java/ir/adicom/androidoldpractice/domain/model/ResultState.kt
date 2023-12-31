package ir.adicom.androidoldpractice.domain.model

sealed class ResultState<T> {
    data class Loading<T>(val data: T) : ResultState<T>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error<T>(val throwable: Throwable, val data: T?) : ResultState<T>()
}