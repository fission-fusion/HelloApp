package Lesson6_7_type_conversion

fun main() {
    val number = "12.777777777777"
    println(number.split(".")[0].toInt())
    println(Regex("(\\d+\\.\\d{3})").findAll(number).map{it.groupValues[1]}.joinToString().toFloat())
    println((number.split(".")[0].toInt().toString(2)))

    task2(2)
    task2(2.0)
    task2("2")
    task2('2')
    task2(listOf(1,2))

    task3(2)
    task3("два")
    task3(arrayOf(1,2))
    task3(arrayOf(1,null))
    task3(arrayOf(1,"2"))
    task3(listOf(1,2))
    task3(listOf(1,null))
    task3(listOf(1,"2"))
    task3(2.0)
}

fun <T>task2(a: T) {
    when (a) {
        is Int -> println("Это число")
        is Double -> println("Это число с плавающей точкой")
        is Float -> println("Это число с плавающей точкой")
        is String -> println("Это строка")
        is Char -> println("Это символ")
        else -> println("Это ни число, ни строка, ни символ")
    }
}

fun <T>task3(a: T) {
    when (a) {
        is Int -> println(a + 1)
        is String -> println(a.length + 1)
        is Array<*> -> {if (a.all{(it is Int) || (it == null)}) println(a.size) else println("Массив не целых чисел")}
        is List<*> -> {if (a.all{(it is Int) || (it == null)}) println(a.size) else println("Список не целых чисел")}
        else -> println("Ни целое число, ни строка, ни массив, ни список целых чисел")
    }
}