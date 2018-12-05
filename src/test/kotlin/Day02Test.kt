import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Test {

    private val day02 = Resources.linesFrom("day02.txt")

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

    @Test
    fun `example of common letter of correct box IDs`() {
        val commonLetters: String = Day02.commonLettersOfCorrectBoxIds(
            listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz")
        )

        assertThat(commonLetters).isEqualTo("fgij")
    }

    @Test
    fun `answer part 2`() {
        val commonLetters: String = Day02.commonLettersOfCorrectBoxIds(day02)

        assertThat(commonLetters).isEqualTo("wmlnjevbfodamyiqpucrhsukg")
    }
}