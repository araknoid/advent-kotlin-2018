import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResourcesTest {

    @Test
    fun `load example file`() {
        val lines = Resources.linesFrom("example.txt")

        assertThat(lines)
            .hasSize(4)
            .containsExactly("1", "0", "A", "Z")
    }
}