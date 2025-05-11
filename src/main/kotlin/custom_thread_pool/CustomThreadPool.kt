package org.example.custom_thread_pool

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

fun main() {
    /** create executor and apply graceful shutdown
     * using org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
     * */
    val executor = Executors.newFixedThreadPool(4)

    /** make custom executor as dispatcher and use it
     * @see asCoroutineDispatcher
     * */
    val dispatcher = executor.asCoroutineDispatcher()
    runBlocking(dispatcher) {  }
}