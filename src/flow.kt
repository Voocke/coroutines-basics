import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

fun main() = runBlocking {
    val myFlow = makeFlow()
        .filter { it % 2 == 0 }
        .map { value -> "Получено число: $value" }
        .flowOn(Dispatchers.IO)

    println("Flow создан, но ещё не запущен")
    delay(1000)
    myFlow.collect { value -> println("Collected $value on ${Thread.currentThread().name}") }
}
fun makeFlow(): Flow<Int> {
    return flow {
        println("флоу запущен")
        repeat(5){i ->
            println("Emitting $i on ${Thread.currentThread().name}")
            emit(i)
            delay(1000)
        }
    }
}