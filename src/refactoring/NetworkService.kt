package refactoring

import kotlinx.coroutines.*

class NetworkService (val dispatcher: CoroutineDispatcher = Dispatchers.IO) {
    suspend fun fetchData(): String {
        // Имитация долгого запроса
        return withContext(dispatcher) {
            delay(2000)
            "Data from Server ${Thread.currentThread().name}"
        }
    }
}