import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Test {

    val day02 = Resources.linesFrom("day02.txt")

    @Test
    fun `example of checksum`() {
        val checksum: Int = Day02.checksum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))

        assertThat(checksum).isEqualTo(12)
    }

    @Test
    fun `answer part 1`() {
        val checksum: Int = Day02.checksum(day02)

        assertThat(checksum).isEqualTo(7350)
    }
}