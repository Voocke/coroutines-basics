import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking{
    launch(Dispatchers.Default) {
        val time = measureTimeMillis {
        val deferredCoffee = async { makeCoffee() }
        val deferredToast = async { makeToast() }
        println("Breakfast is ready: ${deferredCoffee.await()} & ${deferredToast.await()}")
        }
    println("$time ms")
    }
    Unit
}

// or

//fun main() = runBlocking{
//    val time = measureTimeMillis {
//        withContext(Dispatchers.Default) {
//            val deferredCoffee = async { makeCoffee() }
//            val deferredToast = async { makeToast() }
//            println("Breakfast is ready: ${deferredCoffee.await()} & ${deferredToast.await()}")
//        }
//    }
//    println("$time ms")
//}
suspend fun makeCoffee(): String {
    println(Thread.currentThread().name)
    delay(1000)
    return "Coffee"
}
suspend fun makeToast(): String {
    println(Thread.currentThread().name)
    delay(1000)
    return "Toast"
}
