package refactoring

import kotlinx.coroutines.*

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class) //попросили что бы убрать предупреждения
fun main() = runBlocking {
    val testDispatcher = newSingleThreadContext("MyTestThread")

    val networkService = NetworkService(testDispatcher)
    println(networkService.fetchData())
    testDispatcher.close()
}