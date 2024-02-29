import java.io.DataInput
import java.io.File



class Day2Efter(input: String){

    private val calories = parseInput(input)

    private fun parseInput(input: String): List<Int> =
        input
            .trim()
            .split("\n\n")
            .map { it.lines().sumOf(String::toInt) }
            .sortedDescending()

    fun solvePart1(): Int =
        calories.first()

    fun solvePart2(): Int =
        calories.take(3).sum()
}

fun main() {
    val day1Efter = Day2Efter("C:\Users\fs308\IdeaProjects\Aoc-2022-Funktionell-Programmering\src\Day1\Input")
    println( day1Efter.solvePart1())
    println( day1Efter.solvePart2())

}
