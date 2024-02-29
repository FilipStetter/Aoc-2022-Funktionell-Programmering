import java.io.File

//Källa https://todd.ginsberg.com/post/advent-of-code/2022/day3/
//Ganska lik min första lösning bara mer effektiv skriven och finare

val data3Efter = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day3\\Input").readLines()


fun solvePart1Efter(data: List<String>): Int {
    var sum = 0
    for (line in data) {
        sum += sharedItemEfter(line).priority()
    }
    return sum
}

fun solvePart2Efter(data: List<String>): Int {
    var sum = 0
    for (chunk in data.chunked(3)) {
        sum += sharedItemEfter(chunk.joinToString("")).priority()
    }
    return sum
}

private fun Char.priority(): Int {
    return when {
        this in 'a'..'z' -> this - 'a' + 1
        this in 'A'..'Z' -> this - 'A' + 27
        else -> throw IllegalArgumentException("Letter not in range: $this")
    }
}

private fun sharedItemEfter(str: String): Char {
    val halfLength = str.length / 2
    val firstHalf = str.substring(0 until halfLength)
    val secondHalf = str.substring(halfLength until str.length)
    val combinedSet = firstHalf.toSet().intersect(secondHalf.toSet())
    return combinedSet.first()
}

fun main() {

    println(solvePart1Efter(data3Efter))
    println(solvePart2Efter(data3Efter))
}