package day01

import java.io.File
import kotlin.math.abs

fun main() {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val regex = Regex("(\\d+)\\s+(\\d+)")
    File("src/main/kotlin/day01/input.txt").forEachLine { line ->
        val matchResult = regex.find(line) ?: throw Exception()
        val (firstNumber, secondNumber) = matchResult.destructured
        left.add(firstNumber.toInt())
        right.add(secondNumber.toInt())
    }
    left.sort()
    right.sort()

    val result = left.zip(right).sumOf { abs(it.first - it.second) }

    print(result)
}

