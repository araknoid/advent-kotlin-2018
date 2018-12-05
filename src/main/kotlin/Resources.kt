class Resources {

    companion object {
        fun linesFrom(filename: String): List<String> {
            return Resources::class.java.getResource(filename).readText().lines()
        }
    }
}