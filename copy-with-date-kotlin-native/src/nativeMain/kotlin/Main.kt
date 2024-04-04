import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun main() {
    println("Hello, Kotlin/Native!")

    val currentMoment = Clock.System.now()
    val dateTime = currentMoment.toLocalDateTime(TimeZone.currentSystemDefault())
    println(dateTime.date)
}
