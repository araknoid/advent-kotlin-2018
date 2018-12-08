import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day05Test {

    @Test
    fun `example part 1`() {
        val unit = Day05.solvePart1("dabAcCaCBAcCcaDA")

        assertThat(unit).isEqualTo(10)
    }
}