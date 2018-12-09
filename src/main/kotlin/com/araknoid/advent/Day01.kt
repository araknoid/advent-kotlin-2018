package com.araknoid.advent

/**
 * Day 1: Chronal Calibration
 *
 * Description: http://adventofcode.com/2018/day/1
 */
class Day01 {

    companion object {
        fun sum(elements: List<String>): Int = elements.map { it.toInt() }.sum()

        fun frequencyRepeatedTwice(elements: List<String>): Int {
            val list = mutableSetOf<Int>()
            var sum = 0
            return elements.map { it.toInt() }
                .asRepeatedSequence()
                .map {
                    sum += it
                    sum
                }.first { !list.add(sum) }
        }

        private fun List<Int>.asRepeatedSequence() = generateSequence(0) { (it + 1) % this.size }.map(::get)
    }

}