import kotlinx.coroutines.*

fun main() = runBlocking {

    supervisorScope {
        //в отличие от coroutineScope при ошибке не дропает все корутины,
        //а только ту что кинула ошибку
        launch {
            delay(2000)
            println("корутина А выжила!")
        }
        launch {
            delay(500)
            throw RuntimeException("BOOM!")
        }
        Unit
    }
}