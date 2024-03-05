import java.io.File

class Day1före{

    val data: List<String> = File("C:\\Users\\fs308\\IdeaProjects\\Aoc-2022-Funktionell-Programmering\\src\\Day1\\Input").readLines()


    fun sortDataPart1(): Int {
        var maxSum = 0
        var currentSum = 0

        for (line in data) {
            if (line.isBlank()) {
                maxSum = maxOf(maxSum, currentSum)
                currentSum = 0
            } else {
                currentSum += line.toInt()
            }
        }

        maxSum = maxOf(maxSum, currentSum)

        return maxSum
    }

    fun sortDataPart2(): Int {
        val topSums = mutableListOf<Int>()
        var currentSum = 0

        for (line in data) {
            if (line.isBlank()) {
                if (topSums.size < 3) {
                    topSums.add(currentSum)
                } else {
                    val minTopSum = topSums.minOrNull() ?: Int.MIN_VALUE
                    if (currentSum > minTopSum) {
                        topSums[topSums.indexOf(minTopSum)] = currentSum
                    }
                }
                currentSum = 0
            } else {
                currentSum += line.toInt()
            }
        }

        return topSums.sum()
    }

}


fun main() {
    val day1före = Day1före()
    val sumPart1 = day1före.sortDataPart1()
    val sumPart2 = day1före.sortDataPart2()
    println("Max Calories: $sumPart1")
    println("Calories of top 3 Elves: $sumPart2")
}


