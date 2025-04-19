Concept of Kotlin Coroutines

- Enable the use of user-level concurrency
    - in the JVM, multi-threading utilizes platform threads, which are mapped one to one with kernel threads
        - when a platform thread is blocked, it means related kernel thread is blocked too
    - coroutines provide user-level concurrency, where multiple coroutines can be executed on a single platform thread (1:N mapping)
- Establish a hierarchy between coroutine jobs
    - corooutines can be structured hierarchically using `Job` objects
    - a parent job can wait until all of its child coroutines complete
    - if a parent job is canceled, all of its child coroutines are also canceled
- Increase availability of platform thread by suspending execution
    - when a coroutine calls a `suspend` function, it does not block the platform thread but suspends execution, allowing other coroutines to run on the same thread
    - resumption happens when the suspended function completes and scheduled again


[CoroutineScope](src/main/kotlin/coroutine_scope/CoroutineScope.kt)

- Provide and manage CoroutineContext

[CoroutineContext](src/main/kotlin/coroutine_context/CoroutineContext.kt)

- Interface that defines the execution environment for coroutines
- Key-Value set of elements (`Element` is a inner class of `CoroutineContext`)

[Brief Overview of implementations of CoroutineContext](src/main/kotlin/implementations_of_coroutine_context/ImplementationsOfCoroutineContext.kt)

- CoroutineDispatcher
    - determines the execution thread (platform thread) for coroutines
    - responsible for scheduling coroutine execution and managing thread allocation
- Job
    - represents a cancellable unit of work in a coroutine
    - manages coroutine’s lifecycle

Important Keywords

- [`intercept`](src/main/kotlin/intercept/Intercept.kt)
  - a behavior of linking a continuation to a dispatcher via a interceptor (`ContinuationInterceptor`)
    - this allows the dispatcher to control how and where the continuation resumes
  - `unintercepted` ⇒ not linked yet
  - `intercepted` ⇒ linked, ready to be dispatched
- `dispatch`
  - a behavior of submitting a continuation (`runnable`) into the dispatcher’s task queue (e.g. `LimitedDispatcher`)
  - `undispatched` ⇒ not submitted
  - `dispatched` ⇒ submitted (scheduled)
    - after dispatched, CoroutineScheduler assigns a task in dispatcher’s task queue to a specific worker thread

[Dispatcher & Scheduler & Worker](src/main/kotlin/schduler/CoroutineScheduler.kt)

- Dispatcher
  - Singleton instance
  - dispatches coroutine tasks to Scheduler (`CoroutineScheduler`)
  - defines dispatch policy (e.g. `limitedParallelism`)
- Scheduler
  - actually acts as singleton (shares one instance during runtime)
  - manages OS-level worker threads (its own pool)
  - lazily creates workers up to `corePoolSize` / `maxPoolSize`
  - has two global queues
    - `globalCpuQueue` (for CPU-bound tasks)
    - `globalBlockingQueue` (for IO-blocking tasks)
  - implements work stealing & thread parking/unparking
- Worker
  - is a OS thread managed by Scheduler
  - has local task queue
  - can steal tasks from global task queue of Scheduler