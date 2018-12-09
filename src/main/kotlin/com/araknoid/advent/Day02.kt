package com.araknoid.advent

/**
 * Day 2: Inventory Management System
 *
 * Description: http://adventofcode.com/2018/day/2
 */
class Day02 {
    companion object {
        fun checksum(boxes: List<String>): Int =
            boxes.count { it.containsALetterTimes(2) } * boxes.count { it.containsALetterTimes(3) }

        fun commonLettersOfCorrectBoxIds(boxesIDs: List<String>): String {
            for (boxId in boxesIDs.withIndex()) {
                for (i in boxId.index until boxesIDs.size) {
                    if (boxId.value.oneCharDifference(boxesIDs[i])) {
                        return boxId.value.commonLettersWith(boxesIDs[i])
                    }
                }
            }
            return ""
        }
    }
}

private fun String.containsALetterTimes(times: Int): Boolean =
    this.groupBy { it }.values.map { it.size }.contains(times)

private fun String.oneCharDifference(other: String): Boolean =
    this.zip(other).count { it.first != it.second } == 1

private fun String.commonLettersWith(other: String): String =
    this.zip(other).filter { it.first == it.second }.map { it.first }.joinToString("")