package com.araknoid.advent

class Resources {
    companion object {
        fun linesFrom(filename: String): List<String> {
            return Resources::class.java.classLoader.getResource(filename).readText().lines()
        }

        fun from(filename: String): String {
            return Resources::class.java.classLoader.getResource(filename).readText()
        }
    }
}