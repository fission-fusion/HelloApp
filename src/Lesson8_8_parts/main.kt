package Lesson8_8_parts

fun main() {
    val numbers = (1..20).toList()
    println(numbers.drop(4).count { it % 2 == 0 })

    println(numbers.take(7).sum())

    val list = listOf("one", "two", "three")
    println(list.map { it.toList() }.flatten())

    println(list.maxBy { it.length })

    val products = listOf(
        Product("Сыр", 20),
        Product("Молоко", 5),
        Product("Творог", 15),
        Product("Йогурт", 20)
    )
    println(products.map { it.quantity }.fold(0) {cnt, quantity -> cnt + quantity})
}

class Product(val name: String, val quantity: Int) {
}