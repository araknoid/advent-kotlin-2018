class Day03 {
    companion object {
        fun overlappingFabrics(claims: List<String>): Int =
            claims.asSequence()
                .flatMap { Claim.from(it).asPositionsList().asSequence() }
                .groupBy { it }
                .values
                .map { it.size }
                .count { it > 1 }
    }
}

data class Position(val x: Int, val y: Int)

data class Claim(val x: Int, val y: Int, val width: Int, val height: Int) {

    fun asPositionsList(): List<Position> {
        val list = mutableListOf<Position>()
        for (i in x until (x + width)) {
            for (j in y until (y + height)) {
                list.add(Position(i, j))
            }
        }
        return list
    }

    companion object {
        fun from(claim: String): Claim {
            val (position, size) = claim.split(" @ ")[1].split(": ")
            val (x, y) = position.split(",")
            val (width, height) = size.split("x")
            return Claim(x.toInt(), y.toInt(), width.toInt(), height.toInt())
        }
    }

}
