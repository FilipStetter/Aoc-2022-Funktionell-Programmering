import java.io.File
// Andvände mig utav denna källa https://medium.com/@inzuael/advent-of-code-2022-using-kotlin-3fec4c0b23c6
// Mycket simplare och finare som använder sig utav bibliotek som Kotlin har för att lösa problemet. Och jag behöver inte skriva om hela functionen för part 1 och 2 som jag gjorde i Day1Före.





class Day1Efter() {

    val data: List<String> = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day1\\Input").readLines()

     fun List<String>.calculateElfAmounts(): List<Int> {
        val elvesAmount = mutableListOf(0)
        forEach {
            if (it.isNotBlank()) {
                elvesAmount[elvesAmount.lastIndex] += it.toInt()
            } else {
                elvesAmount.add(0)
            }
        }
        return elvesAmount.toList()
    }

    fun solvePart1(): Int {
        return data.calculateElfAmounts().maxOrNull() ?: 0
    }

    fun solvePart2(): Int {
        return data.calculateElfAmounts().sortedDescending().take(3).sum()
    }
}

fun main() {
    val day1Efter = Day1Efter()
    println("Max Calories: ${day1Efter.solvePart1()}")
    println("Calories of top 3 Elves: ${day1Efter.solvePart2()}")
}
