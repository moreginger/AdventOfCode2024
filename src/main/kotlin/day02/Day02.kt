package day02

import java.io.File
import kotlin.math.abs

fun main() {
    val result1 = File("src/main/kotlin/day02/input.txt").useLines { lines ->
        lines.map { line ->
            val list = line.split(" ").map { it.toInt() }
            val diffs = list.mapIndexed { index, i -> if (index == 0) 0 else i - list[index - 1] }.drop(1)
            (diffs.all { it > 0 } || diffs.all { it < 0 }) && diffs.all { abs(it) <= 3 }
        }.toList()
    }.count { it }

    println(result1)

    val result2 = File("src/main/kotlin/day02/input.txt").useLines { lines ->
        lines.map { line ->
            val list = line.split(" ").map { it.toInt() }
            list.indices.any { toRemove ->
                val subList = list.toMutableList().apply { removeAt(toRemove) }
                val diffs = subList.mapIndexed { index, i -> if (index == 0) 0 else i - subList[index - 1] }.drop(1)
                (diffs.all { it > 0 } || diffs.all { it < 0 }) && diffs.all { abs(it) <= 3 }
            }
        }.toList()
    }.count { it }

    println(result2)
}