import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        while (true){
            println("Работаю...")
            delay(500)
        }
    }
    delay(1200)
    println("Останавливаю!")
    job.cancel()
    job.join()
    delay(1000)
}