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

            fun isEdge(x: Int, y: Int) = x == xRange.first || x == xRange.last || y == yRange.first || y == yRange.last

            val edgePoints = mutableSetOf<Position>()

            return xRange.asSequence()
                .flatMap { x ->
                    yRange.asSequence()
                        .map { y ->
                            val closest =
                                positions.map { it to it.distanceTo(x, y) }
                                    .sortedBy { it.second }
                                    .take(2)

                            if (isEdge(x, y)) {
                                edgePoints.add(closest[0].first)
                            }

                            closest[0].first.takeUnless { closest[0].second == closest[1].second }
                        }
                }
                .filterNotNull()
                .filterNot { it in edgePoints }
                .groupBy { it }
                .map { it.key to it.value.size }
                .maxBy { it.second }!!.second
        }

        fun solvePart2(coordinates: List<String>, sum: Int): Int {

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
                            positions.map { it.distanceTo(x, y) }.sum()
                        }
                }
                .count { it < sum }
        }
    }
}