import java.io.File

val data2Före = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day2\\Input").readLines()


fun part1(input: List<String>): Int {
    var totalScore = 0


    val ptMap = mapOf(
        "A" to mapOf("Z" to 0, "X" to 3, "Y" to 6),
        "B" to mapOf("X" to 0, "Y" to 3, "Z" to 6),
        "C" to mapOf("Y" to 0, "Z" to 3, "X" to 6)
    )

    for (line in input) {
        val hands = line.split(" ")

        totalScore += when (hands[1]) {
            "X" -> 1
            "Y" -> 2
            "Z" -> 3
            else -> 0
        }

        totalScore += ptMap.getOrDefault(hands[0], mapOf())
            .getOrDefault(hands[1], 0)
    }

    return totalScore
}

fun part2(input: List<String>): Int {
    var totalScore = 0


    val ptMap = mapOf(
        "A" to mapOf("Y" to 1, "Z" to 2, "X" to 3),
        "B" to mapOf("X" to 1, "Y" to 2, "Z" to 3),
        "C" to mapOf("Z" to 1, "X" to 2, "Y" to 3)
    )

    for (line in input) {
        val hands = line.split(" ")

        totalScore += when (hands[1]) {
            "Y" -> 3
            "Z" -> 6
            else -> 0
        }

        totalScore += ptMap.getOrDefault(hands[0], mapOf())
            .getOrDefault(hands[1], 0)
    }

    return totalScore
}



fun main() {
    println(part1(data2Före))
    println(part2(data2Före))


}