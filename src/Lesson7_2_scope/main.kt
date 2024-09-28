package Lesson7_2_scope

fun main() {
    "word".let{println("$it ${it.length}")}
    "word".also{println("$it ${it.length}")}

    val city1 = City("Казань")
    city1.apply{population = 1318604}
    city1.also{it.population = 1500000}
    city1.getInfo()

    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    with(numbers) {println("$numbers, количество элементов - ${numbers.size}, сумма элементов - ${numbers.sum()}")}
}


class City(var name: String) {
    var population: Int = 0

    fun getInfo() {
        println("Город - $name, население - $population")
    }
}