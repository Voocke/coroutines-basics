import kotlinx.coroutines.*

class NetworkService {
    suspend fun fetchData(): String {
        // Имитация долгого запроса
        return withContext(Dispatchers.IO) {
            delay(1000)
            "Data from Server"
        }
    }
}