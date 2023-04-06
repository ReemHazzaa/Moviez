package com.example.domain.usecase

abstract class BaseUseCase<in Params, out Type> {
    abstract suspend fun execute(params: Params): Type
}