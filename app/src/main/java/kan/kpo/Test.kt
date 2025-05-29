import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking



fun main(){

    runBlocking {
        CoundownTimer().collect{
            println("countdown: " + it)
        }
    }

}


var startTime = 10
fun CoundownTimer() : Flow<Int> {
    return flow {
        while (startTime >= 0) {
            emit(startTime)
            delay(500)
            startTime--

        }

        println("Mohter fker")
    }
}


