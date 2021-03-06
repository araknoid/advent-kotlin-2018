package com.araknoid.advent

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day03Test {

    private val day03Claims = Resources.linesFrom("day03.txt")

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
        val overlappingFabrics = Day03.overlappingFabrics(day03Claims)

        assertThat(overlappingFabrics).isEqualTo(117948)
    }

    @Test
    fun `claim without overlapping fabrics`() {
        val claims = listOf(
            "#1 @ 1,3: 4x4",
            "#2 @ 3,1: 4x4",
            "#3 @ 5,5: 2x2"
        )

        val claim = Day03.claimWithoutOverlappingFabrics(claims)

        assertThat(claim).isEqualTo("#3 @ 5,5: 2x2")
    }

    @Test
    fun `part 2 answer`() {
        val claim = Day03.claimWithoutOverlappingFabrics(day03Claims)

        assertThat(claim).isEqualTo("#567 @ 370,732: 23x19")
    }
}