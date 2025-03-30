package org.example.intercept

import kotlin.coroutines.*

fun main() {
    /**
     * @see createCoroutine
     * Coroutine is created as unintercepted and then intercepted
     * */
    val simpleLambda: suspend () -> Unit = { }
    val continuation = object : Continuation<Unit> {
        override val context: CoroutineContext = EmptyCoroutineContext
        override fun resumeWith(result: Result<Unit>) { }
    }
    simpleLambda.createCoroutine(continuation)
}

