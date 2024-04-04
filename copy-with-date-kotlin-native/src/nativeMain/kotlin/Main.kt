import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import okio.FileSystem
import okio.Path.Companion.toPath
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Wrong command, usage: A app.apk")
        exitProcess(1)
    }
    val name = args[0]
    val newName = createNewName(name)

    val source = name.toPath()
    val target = newName.toPath()

    val size = FileSystem.SYSTEM.metadata(source).size
    if (size != null) {
        println("$name -> $newName, size=$size")
    } else {
        println("$name -> $newName")
    }

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
