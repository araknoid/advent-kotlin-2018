package com.araknoid.advent

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day06Test {

    @Test
    fun `example of part 1`() {
        val coordinates = listOf(
            "1, 1",
            "1, 6",
            "8, 3",
            "3, 4",
            "5, 5",
            "8, 9"
        )

        val area = Day06.solvePart1(coordinates)

        assertThat(area).isEqualTo(17)
    }

    @Test
    fun `answer part 1`() {
        val coordinates = Resources.linesFrom("day06.txt")

        val area = Day06.solvePart1(coordinates)

        assertThat(area).isEqualTo(3871)
    }


    @Test
    fun `example of part 2`() {
        val coordinates = listOf(
            "1, 1",
            "1, 6",
            "8, 3",
            "3, 4",
            "5, 5",
            "8, 9"
        )

        val area = Day06.solvePart2(coordinates, 32)

        assertThat(area).isEqualTo(16)
    }

    @Test
    fun `answer part 2`() {
        val coordinates = Resources.linesFrom("day06.txt")

        val area = Day06.solvePart2(coordinates, 10000)

        assertThat(area).isEqualTo(44667)
    }
}