import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day01Test {

    val day01 = Resources.linesFrom("day01.txt")

    @Test
    fun `sum of example`() {
        val sum = Day01.sum(listOf("+1", "-2", "+3", "-1"))

        assertThat(sum).isEqualTo(1)
    }

    @Test
    fun `answer part 1`() {
        val sum = Day01.sum(day01)

        assertThat(sum).isEqualTo(538)
    }

    @Test
    fun `frequency repeated twice`() {
        val frequency = Day01.frequencyRepeatedTwice(listOf("+1", "-2", "+3", "-1", "-8", "+4"))

        assertThat(frequency).isEqualTo(1)
    }
}