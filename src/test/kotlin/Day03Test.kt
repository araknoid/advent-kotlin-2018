import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun `claims of overlapping fabrics`() {
        val claims = listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        )

        val overlappingFabrics = Day03.overlappingFabrics(claims)

        assertThat(overlappingFabrics).isEqualTo(4)
    }

    @Test
    fun `part 1 answer`() {
        val claims = Resources.linesFrom("day03.txt")

        val overlappingFabrics = Day03.overlappingFabrics(claims)

        assertThat(overlappingFabrics).isEqualTo(117948)
    }
}