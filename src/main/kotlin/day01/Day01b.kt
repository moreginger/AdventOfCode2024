package day01

import java.io.File
import kotlin.math.abs

fun main() {
    val left = mutableListOf<Int>()
    val right = mutableMapOf<Int, Int>()
    val regex = Regex("(\\d+)\\s+(\\d+)")
    File("src/main/kotlin/day01/input.txt").forEachLine { line ->
        val matchResult = regex.find(line) ?: throw Exception()
        val (firstNumber, secondNumber) = matchResult.destructured
        left.add(firstNumber.toInt())
        right[secondNumber.toInt()] = (right[secondNumber.toInt()] ?: 0) + 1
    }

    val result = left.sumOf { it * (right[it] ?: 0) }

    print(result)
}

