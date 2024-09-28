package Lesson7_6_Map

fun main() {
    val array = arrayOf(2, 4, 7, 1, 2, 4)
    val dict = mutableMapOf<Int, Int>()
    for (i in array) {
        dict[i] = dict.getOrDefault(i, 0) + 1
    }
    println(dict.toSortedMap())
    println(array.groupingBy{it}.eachCount().toSortedMap())

    val people = mutableMapOf(1 to "Иван", 2 to "Петр",3 to "Лида", 4 to "Петр", 5 to "Анна")
    println(deleteElement(people))

    val personHashMap = mutableMapOf<Int, Person>()
    personHashMap.put(0, Person("Алла", 30, "бухгалтер"))
    personHashMap.put(1, Person("Иван", 33, "программист"))
    personHashMap.put(2, Person("Елена", 31, "юрист"))
    println(personHashMap)
}

fun deleteElement(dict: MutableMap<Int, String>):  Map<Int, String>{
    println("Введите имя,которое хотите удалить:")
    val valueToDelete = readLine()
    return dict.filter{it.key !in dict.filter{it.value == valueToDelete}.keys}
}

data class Person(val name: String, val age: Int, val position: String) {
}