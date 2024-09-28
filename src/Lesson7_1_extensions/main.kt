package Lesson7_1_extensions

import kotlin.math.sqrt

fun main() {
    println(5.raiseToThePower(3))
    println("1".toConcat("2", "3"))
    println("два".getLastIndex())
    println(9.getRoot())

}

fun Int.raiseToThePower(pow: Int): Int {
    var result = 1
    for (i in 0..<pow) result *= this
    return result
}

fun String.toConcat(vararg lines: String): String {
    val result = StringBuilder(this)
    for (line in lines) {
        result.append(line)
    }
    return result.toString()
}

fun String.getLastIndex(): Int {
    return this.length - 1
}

fun Int.getRoot(): Double {
    return sqrt(this.toDouble())
}