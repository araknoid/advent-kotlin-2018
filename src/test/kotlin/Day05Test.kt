import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    private val example = "dabAcCaCBAcCcaDA"
    private val polymer = Resources.from("day05.txt")

    @Test
    fun `example part 1`() {
        val unit = Day05.solvePart1(example)

        assertThat(unit).isEqualTo(10)
    }

    @Test
    fun `answer part 1`() {
        val unit = Day05.solvePart1(polymer)

        assertThat(unit).isEqualTo(9348)
    }

    @Test
    fun `example part 2`() {
        val unit = Day05.solvePart2(example)

        assertThat(unit).isEqualTo(4)
    }

    @Test
    fun `solve part 2`() {
        val unit = Day05.solvePart2(polymer)

        assertThat(unit).isEqualTo(4996)
    }
}