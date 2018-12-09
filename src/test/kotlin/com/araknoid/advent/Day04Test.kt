package com.araknoid.advent

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day04Test {

    private val example = listOf(
        "[1518-11-01 00:00] Guard #10 begins shift",
        "[1518-11-01 00:05] falls asleep",
        "[1518-11-01 00:25] wakes up",
        "[1518-11-01 00:30] falls asleep",
        "[1518-11-01 00:55] wakes up",
        "[1518-11-01 23:58] Guard #99 begins shift",
        "[1518-11-02 00:40] falls asleep",
        "[1518-11-02 00:50] wakes up",
        "[1518-11-03 00:05] Guard #10 begins shift",
        "[1518-11-03 00:24] falls asleep",
        "[1518-11-03 00:29] wakes up",
        "[1518-11-04 00:02] Guard #99 begins shift",
        "[1518-11-04 00:36] falls asleep",
        "[1518-11-04 00:46] wakes up",
        "[1518-11-05 00:03] Guard #99 begins shift",
        "[1518-11-05 00:45] falls asleep",
        "[1518-11-05 00:55] wakes up"
    )

    private val shifts = Resources.linesFrom("day04.txt")

    @Test
    fun `example of part 1`() {

        val id = Day04.solvePart1(example)

        assertThat(id).isEqualTo(240)

    }

    @Test
    fun `answer part 1`() {

        val id = Day04.solvePart1(shifts)

        assertThat(id).isEqualTo(39584)

    }

    @Test
    fun `example of part 2`() {
        val id = Day04.solvePart2(example)

        assertThat(id).isEqualTo(4455)

    }

    @Test
    fun `answer part 2`() {
        val id = Day04.solvePart2(shifts)

        assertThat(id).isEqualTo(55053)

    }
}