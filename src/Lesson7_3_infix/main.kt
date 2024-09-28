package Lesson7_3_infix

fun main() {
    println(1 plus 2)
    println(5 minus 4)
    println(2 multiply 3)
    println(6 divide 2)

    val person1 = Person("Иван")
    person1 say "Hello"

    val point1 = Point(7.0, 1.0)
    val point2 = Point(3.0, 5.0)
    println(point1 isAbove point2)
    println(point1 isRightOf point2)
}

infix fun Number.plus(value: Number): Number {
    return when {
        this is Int && value is Int -> this + value
        this is Int && value is Double -> this + value
        this is Double && value is Double -> this + value
        this is Double && value is Int -> this + value
        else -> throw Exception("Не Number")
    }
}

infix fun Number.minus(value: Number): Number {
    return when {
        this is Int && value is Int -> this - value
        this is Int && value is Double -> this - value
        this is Double && value is Double -> this - value
        this is Double && value is Int -> this - value
        else -> throw Exception("Не Number")
    }
}

infix fun Number.multiply(value: Number): Number {
    return when {
        this is Int && value is Int -> this * value
        this is Int && value is Double -> this * value
        this is Double && value is Double -> this * value
        this is Double && value is Int -> this * value
        else -> throw Exception("Не Number")
    }
}

infix fun Number.divide(value: Number): Number {
    return when {
        this is Int && value is Int -> this / value
        this is Int && value is Double -> this / value
        this is Double && value is Double -> this / value
        this is Double && value is Int -> this / value
        else -> throw Exception("Не Number")
    }
}

class Person(val name: String) {
    infix fun say(message: String) {
        println(message)
    }
}

data class Point(val x: Double, val y: Double) {
}

infix fun Point.isAbove(point2: Point): Boolean {return y > point2.y}
infix fun Point.isRightOf(point2: Point): Boolean {return x > point2.x}
