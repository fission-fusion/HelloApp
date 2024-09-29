package Lesson8_6_aggregation

fun main() {
    val numbers1 = listOf(22, 22, 22, 1, 1, 1, 1, 1, 1, 1, 22, 22, 22)
    println(numbers1.foldIndexed(0) { id, sum, element ->
        if ((id >= 3) && (id <= 9)) sum + element else sum
    })

    val numbers = listOf(1, 2, 3, 4)
    println(numbers.fold("") { a, b -> "$a$b" })

    val players = listOf(
        Player("Иван", 10, 100),
        Player("Олег", 20, 200),
        Player("Михаил", 30, 300),
        Player("Иван", 10, 100),
        Player("Олег", 20, 200),
        Player("Михаил", 30, 300)
    )
    val playersHistory = players.groupBy { it.name }
        .map { (name, history) ->
            Player(
                name,
                history.sumOf { it.points },
                history.sumOf { it.money }
            )
        }
    println(playersHistory)

    val fruits = listOf("Яблоко", "Абрикос", "Банан", "Виноград", "Вишня", "Кокос", "яблоко")
    val newFruits = fruits.groupBy { it.first().lowercaseChar() }
        .mapValues { (_, fruits) -> fruits.filter { it.length % 2 == 0 } }
    println(newFruits)
}

data class Player(val name: String, val points: Int, val money: Int) {
}