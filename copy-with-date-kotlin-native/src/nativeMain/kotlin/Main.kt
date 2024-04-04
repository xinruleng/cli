import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.FileSystem
import okio.Path.Companion.toPath

fun main() {
    val name = "README.md"
    val newName = createNewName(name)
    println("$name -> $newName")

    val source = name.toPath()
    val target = newName.toPath()

    FileSystem.SYSTEM.copy(source, target)
}

fun createNewName(name: String, date: LocalDate? = null): String {
    val index = name.lastIndexOf(".")
    val baseName = name.substring(0, index)
    val dateStr = if (date == null) {
        val currentMoment = Clock.System.now()
        currentMoment.toLocalDateTime(TimeZone.currentSystemDefault()).date
    } else {
        date.toString()
    }
    val extension = name.substring(index)
    return "$baseName-$dateStr$extension"
}
