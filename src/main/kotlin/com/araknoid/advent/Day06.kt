package com.araknoid.advent

/**
 * Day 6: Chronal Coordinates
 *
 * Description: https://adventofcode.com/2018/day/6
 */
class Day06 {

    companion object {

        fun solvePart1(coordinates: List<String>): Int {

            val positions = coordinates.map {
                val split = it.split(", ")
                Position(split[0].toInt(), split[1].toInt())
            }

            val xRange = positions.minBy { it.x }!!.x..positions.maxBy { it.x }!!.x
            val yRange = positions.minBy { it.y }!!.y..positions.maxBy { it.y }!!.y

            return xRange.asSequence()
                .flatMap { x ->
                    yRange.asSequence()
                        .map { y ->
                            val closest =
                                positions.map { it to it.distanceTo(x, y) }
                                    .sortedBy { it.second }
                                    .take(2)

                            closest[0].first.takeUnless { closest[0].second == closest[1].second }
                        }
                }
                .filterNot { it?.isEdge(xRange, yRange) ?: false }
                .groupBy { it }
                .mapValues { it.value.size }
                .maxBy { it.value }!!.value
        }
    }
}