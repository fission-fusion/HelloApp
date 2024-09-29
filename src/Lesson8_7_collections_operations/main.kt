package Lesson8_7_collections_operations

fun main() {
    val list = listOf("one", "two", "three")
    println(list.map { it.reversed() })

    val numbers = listOf(1, 2, 3, 4, 5)
    val squareOfNumbers = numbers.filter{ it <= 3}.map{ it * it }
    println( squareOfNumbers)

    val engColors = listOf("red", "blue", "white")
    val ruColors = listOf("красный", "синий", "белый")
    val allColors = engColors.zip(ruColors) { engColor, ruColor ->
        "Значение: $engColor, перевод: $ruColor"
    }
    println(allColors)

    val months = listOf("Jan", "Feb", "Mar", "Apr", "May")
    println(months.fold(0){ sum, element -> sum+ element.length})
}