import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun test_createNewName() {
        val name = "a.apk"
        val date = LocalDate(2024, 4, 3)
        val newName = createNewName(name, date)
        assertEquals("a-2024-04-03.apk", newName)
    }
}
