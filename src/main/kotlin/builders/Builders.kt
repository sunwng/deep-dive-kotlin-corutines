package org.example.builders

import kotlinx.coroutines.*

suspend fun main() {
    /** @see withContext */
    withContext(Dispatchers.IO) { }

    /** @see runBlocking */
    runBlocking(Dispatchers.IO) { }

    /**
     *  @see launch
     *  @see Job
     * */
    val launchResult = CoroutineScope(Dispatchers.Main).launch {  }

    /**
     * @see async
     * @see Deferred
     * */
    val asyncResult = CoroutineScope(Dispatchers.Main).async {  }
    asyncResult.await()
}