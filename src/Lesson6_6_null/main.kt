package Lesson6_6_null

fun main() {
    task1()

    val number1: Int = 15
    val number2: Int = 4
    println(DivideIfWhole(number1, number2))
    println(DivideIfWhole2(number1, number2))

    val array = arrayOf("Привет","как", null, "дела")
    val array2 = array.filterNotNull()
    println(array2)
}

fun task1() {
    println("Напишите название своей любимой книги:")
    val myFavoriteBook: String = readLine()?: "У меня нет любимой книги"
    println(myFavoriteBook)
}

fun DivideIfWhole(number1: Int, number2: Int): Int? {
    if (number2 == 0) throw Exception("Деление на 0 невозможно")
    return if ((number1 % number2) != 0) null else (number1 / number2)
}

fun DivideIfWhole2(number1: Int, number2: Int): Int {
    if (number2 == 0) throw Exception("Деление на 0 невозможно")
    return (number1.toDouble() / number2).takeIf{(it % 1) == 0.0}?.toInt()?: 0
}