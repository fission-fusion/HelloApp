package Lesson7_5_Set

fun main() {
    val numbers = setOf(1,2,3,4,5,6,7,8,9,10)
    val evenNumbers = numbers.filter{it % 2 == 0}
    val oddNumbers = numbers subtract evenNumbers
    println(evenNumbers)
    println(oddNumbers)

    val numbers2 = numbers.map{it * 2}.filter{(it % 5) == 0}
    println(numbers2)

    val numbers3 = listOf(1,2,3,4,5,1,2,3,4,5)
    println(removeDuplicates(numbers3))

    val numbers4 = listOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    println(nullsToTheEnd(numbers4))
}

fun <T> removeDuplicates(collection: Collection<T>?): Set<T> {
    return collection?.toSet()?: emptySet()
}

fun nullsToTheEnd(numbers: List<Int>): List<Int> {
    return numbers.filter{it != 0} + numbers.filter{it == 0}
}