import kotlinx.coroutines.*


fun main() = runBlocking{
    launch {
        downloadData()
    }
    launch {
        downloadData()
    }
    Unit
}
suspend fun downloadData(){
    println("Start downloading [Thread: ${Thread.currentThread().name}]")
    delay(1000)
    println("Downloaded [Thread: ${Thread.currentThread().name}")
}
