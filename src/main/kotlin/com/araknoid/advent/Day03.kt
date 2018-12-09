package com.araknoid.advent

import kotlin.math.abs

/**
 * Day 3: No Matter How You Slice It
 *
 * Description: http://adventofcode.com/2018/day/3
 */
class Day03 {
    companion object {
        fun overlappingFabrics(claims: List<String>): Int =
            claims.asSequence()
                .flatMap { Claim(it).asPositionsList().asSequence() }
                .groupBy { it }
                .values
                .map { it.size }
                .count { it > 1 }

        fun claimWithoutOverlappingFabrics(claimsCodes: List<String>): String {
            val claims = claimsCodes.asSequence().map { Claim(it) }.toList()

            val overlappingClaims: List<Claim> = claims.asSequence()
                .flatMap { c -> c.asPositionsList().map { it to c }.asSequence() }
                .groupBy(Pair<Position, Claim>::first, Pair<Position, Claim>::second)
                .filter { it.value.size > 1 }
                .flatMap { it.value }
                .distinct()

            return claims.filterNot { overlappingClaims.contains(it) }.first().code
        }
    }
}


data class Position(val x: Int, val y: Int) {

    fun distanceTo(x: Int, y: Int): Int = abs(this.x - x) + abs(this.y - y)
}

data class Claim(val code: String) {
    private val x: Int
    private val y: Int
    private val width: Int
    private val height: Int

    init {
        val (position, size) = code.split(" @ ")[1].split(": ")
        val (x, y) = position.split(",")
        val (width, height) = size.split("x").map { it.toInt() }

        this.x = x.toInt()
        this.y = y.toInt()
        this.width = width
        this.height = height
    }

    fun asPositionsList(): List<Position> {
        val list = mutableListOf<Position>()
        for (i in x until (x + width)) {
            for (j in y until (y + height)) {
                list.add(Position(i, j))
            }
        }
        return list
    }
}
