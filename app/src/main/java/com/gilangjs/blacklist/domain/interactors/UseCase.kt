package com.gilangjs.blacklist.domain.interactors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class UseCase<in InputType, out OutputType : Any>(
    coroutineContext: CoroutineContext? = null
) {

    private val coroutineContext = coroutineContext ?: Dispatchers.IO

    abstract suspend fun run(
        params: InputType,
        scope: CoroutineScope
    ): Result<OutputType>

    suspend operator fun invoke(
        params: InputType
    ): Result<OutputType> {
        return withContext(coroutineContext) {
            run(params, this)
        }
    }
}
