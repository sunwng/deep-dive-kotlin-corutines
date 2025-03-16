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