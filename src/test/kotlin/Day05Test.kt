import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun `example part 1`() {
        val polymer = "dabAcCaCBAcCcaDA"

        val unit = Day05.solvePart1(polymer)

        assertThat(unit).isEqualTo(10)
    }

    @Test
    fun `answer part 1`() {
        val polymer = Resources.from("day05.txt")

        val unit = Day05.solvePart1(polymer)

        assertThat(unit).isEqualTo(9348)
    }
}