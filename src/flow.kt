import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun main() = runBlocking {
    val myFlow = makeFlow()
    println("Flow создан, но ещё не запущен")
    delay(1000)
    myFlow.collect { value -> println(value) }
}
fun makeFlow(): Flow<Int> {
    return flow {
        println("флоу запущен")
        repeat(5){i ->
            emit(i)
            delay(1000)
        }
    }
}