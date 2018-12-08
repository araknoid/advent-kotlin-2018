class Day05 {

    companion object {

        private val lowerUpper = """([a-z][A-Z])""".toRegex()
        private val upperLower = """([A-Z][a-z])""".toRegex()

        fun solvePart1(polymer: String): Int {

            var reactedPolymer = polymer

            do {
                val tmpPolymer = reactedPolymer

                lowerUpper.findAll(reactedPolymer)
                    .plus(upperLower.findAll(reactedPolymer))
                    .map { it.value }
                    .filter { it[0].toUpperCase() == it[1] || it[0] == it[1].toUpperCase() }
                    .distinct()
                    .forEach { reactedPolymer = reactedPolymer.replace(it, "") }

            } while (tmpPolymer.length != reactedPolymer.length)

            return reactedPolymer.length
        }
    }
}