import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow

fun main() = runBlocking {
    val events = MutableSharedFlow<String>()

    launch {
        events.collect { println("Подписчик 1 получил событие - $it") }
    }
    launch { events.emit("Событие 1") }


    delay(500)

    launch {
        events.collect { println("Подписчик 2 получил событие - $it") }
    }
    delay(100)
    launch { events.emit("Событие 2") }


    Unit
}