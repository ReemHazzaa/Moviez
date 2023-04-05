package com.example.domain.usecase

abstract class BaseUseCase<out Type, in Params> {
    abstract suspend fun execute(params: Params): Type
}