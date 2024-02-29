import java.io.File

//Källa: https://todd.ginsberg.com/post/advent-of-code/2022/day2/
// Detta var den absolut bästa lösningen jag kunde hitta, men den var svår att skriva om eller implimentera i min egna lösning...


 val data1Efter = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day2\\Input").readLines()



private val part1Scores: Map<String, Int> = mapOf(
    "A X" to 1 + 3,
    "A Y" to 2 + 6,
    "A Z" to 3 + 0,
    "B X" to 1 + 0,
    "B Y" to 2 + 3,
    "B Z" to 3 + 6,
    "C X" to 1 + 6,
    "C Y" to 2 + 0,
    "C Z" to 3 + 3
)

private val part2Scores: Map<String, Int> = mapOf(
    "A X" to 3 + 0,
    "A Y" to 1 + 3,
    "A Z" to 2 + 6,
    "B X" to 1 + 0,
    "B Y" to 2 + 3,
    "B Z" to 3 + 6,
    "C X" to 2 + 0,
    "C Y" to 3 + 3,
    "C Z" to 1 + 6
)

fun solvePart1(input: List<String>): Int =
    input.sumOf { part1Scores[it] ?: 0 }

fun solvePart2(input: List<String>): Int =
    input.sumOf { part2Scores[it] ?: 0 }


fun main() {
    println(solvePart1(data1Efter))
    println(solvePart2(data1Efter))
}