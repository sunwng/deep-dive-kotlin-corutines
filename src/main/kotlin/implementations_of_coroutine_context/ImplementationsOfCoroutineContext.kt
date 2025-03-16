package org.example.ImplementationsOfCoroutineContext

import kotlinx.coroutines.AbstractCoroutine
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.AbstractCoroutineContextElement

fun main() {
    /**
     * CoroutineDispatcher inherits AbstractCoroutineContextElement, which is a implementation of CoroutineContext.Element
     * @see CoroutineDispatcher
     * @see AbstractCoroutineContextElement
     * */
    val dispatcher: CoroutineDispatcher = Dispatchers.IO

    /**
     * Job is an implementation of CoroutineContext.Element
     * AbstractCoroutine, which is a parent class of all concrete coroutine classes, is also a child of Job
     * @see Job
     * @see AbstractCoroutine
     * */
    val job = Job
}