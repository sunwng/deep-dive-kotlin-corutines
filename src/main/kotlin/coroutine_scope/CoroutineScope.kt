package org.example.coroutine_scope

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

fun main() {
    /** @see CoroutineScope */
    val coroutineScope: CoroutineScope = MainScope()
}