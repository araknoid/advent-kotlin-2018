import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    @Test
    fun `sum of example`() {
        val sum = Day01.sum(listOf("+1", "-2", "+3", "-1"))

        assertThat(sum).isEqualTo(1)
    }

}