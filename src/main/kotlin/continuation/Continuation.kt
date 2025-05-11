package org.example.continuation

import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume

fun main() {
    /** @see Continuation */
    val continuation = Continuation<EmptyCoroutineContext>(
        context = EmptyCoroutineContext,
        resumeWith = {}
    )

    /** coroutine thread resumes continuations with resume function
     * @see Continuation.resume
     * @see Continuation.resumeWith
     * */
    continuation.resume(EmptyCoroutineContext)

    /** default implementation of continuation
     * @see kotlin.coroutines.jvm.internal.BaseContinuationImpl
     * */
}