import java.io.File

val data3Före = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day3\\Input").readLines()

    fun solvePart1Day3(input : List<String>): Int {
        var sum = 0
        for (line in input) {
            sum += calculatePriority(line.sharedItem())
        }
        return sum
    }

    fun solvePart2Day3(input : List<String>): Int {
        var sum = 0
        for (chunk in input.chunked(3)) {
            sum += calculatePriority(chunk.sharedItem())
        }
        return sum
    }

    private fun calculatePriority(char: Char): Int {
        return if (char in 'a'..'z') {
            char - 'a' + 1
        } else if (char in 'A'..'Z') {
            char - 'A' + 27
        } else {
            throw IllegalArgumentException("Letter not in range: $char")
        }
    }

    private fun String.sharedItem(): Char {
        val firstHalf = substring(0 until length / 2)
        val secondHalf = substring(length / 2 until length)
        return firstHalf.sharedItemWith(secondHalf)
    }

    private fun List<String>.sharedItem(): Char {
        var intersection: Char? = null
        for (string in this) {
            val set = string.toSet()
            if (intersection == null) {
                intersection = set.first()
            } else {
                intersection = intersection intersect set.first()
            }
        }
        return intersection ?: throw NoSuchElementException("No shared item found")
    }

    private infix fun Char.intersect(other: Char): Char? {
        return if (this == other) {
            this
        } else {
            null
        }
    }

    private fun String.sharedItemWith(other: String): Char {
        val set1 = this.toSet()
        val set2 = other.toSet()
        for (char1 in set1) {
            for (char2 in set2) {
                if (char1 == char2) {
                    return char1
                }
            }
        }
        throw NoSuchElementException("No shared item found")
    }
fun main() {
    println( solvePart1Day3(data3Före))

    println( solvePart2Day3(data3Före))
}
