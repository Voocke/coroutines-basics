import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow

fun main() = runBlocking {
    val state = MutableStateFlow("Start")
    launch {
        state.collect { println("Подписчик 1 получил: $it") }
    }

    delay(1000)
    state.value = "Hello World"


    delay(1000)

    launch {
        state.collect { println("Подписчик 2 получил: $it") }
    }
    delay(1000)
    state.value = "Hello World" //не отобразит повторения


    Unit
}