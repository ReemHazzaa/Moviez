package com.example.moviez.domain.usecase
abstract class BaseUseCase<in Params, out Type> {
    abstract suspend fun execute(params: Params): Type
}