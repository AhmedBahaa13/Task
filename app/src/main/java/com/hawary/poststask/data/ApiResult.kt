package com.hawary.poststask.data

sealed class ApiResult<R>{
    class Success<T>(val data:T):ApiResult<T>()
    class Error<T>(val errorMessage: String):ApiResult<T>()
    class Loading<T>():ApiResult<T>()
}
