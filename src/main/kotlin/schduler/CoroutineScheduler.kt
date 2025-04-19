package org.example.schduler

import kotlinx.coroutines.Dispatchers

fun main() {
    /**
     * DefaultScheduler inherits SchedulerCoroutineDispatcher, which has a CoroutineScheduler
     * @see kotlinx.coroutines.scheduling.DefaultScheduler
     * @see kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher
     * */
    val scheduler = Dispatchers.Default

    /**
     * CoroutineScheduler manages thread pool of coroutine
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.corePoolSize
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.maxPoolSize
     *
     * it has two queues (cpu, io)
     * @see kotlinx.coroutines.scheduling.GlobalQueue
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.globalCpuQueue
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.globalBlockingQueue
     *
     * it creates worker threads
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.createNewWorker
     * */

    /**
     * Worker is an OS-level Thread
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
     *
     * its task local queue
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.localQueue
     *
     * Worker can steal tasks from global queue of Scheduler
     * @see kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.findAnyTask
     * */
}