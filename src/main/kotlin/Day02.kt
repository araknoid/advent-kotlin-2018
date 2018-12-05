class Day02 {
    companion object {
        fun checksum(boxes: List<String>): Int =
            boxes.count { it.containsALetterTimes(2) } * boxes.count { it.containsALetterTimes(3) }
    }
}

private fun String.containsALetterTimes(times: Int): Boolean =
    this.groupBy { it }.values.map { it.size }.contains(times)
