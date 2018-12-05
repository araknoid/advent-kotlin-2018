import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day02Test {

    @Test
    fun `example of checksum`() {
        val checksum: Int = Day02.checksum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))

        assertThat(checksum).isEqualTo(12)
    }
}