package Lesson6_5_exception

fun main() {
    val catalog = Catalog()
    catalog.greeting()
    catalog.addPerson()
}

class MyException(message: String) : Exception(message)

class Catalog(var catalog: MutableList<String> = MutableList(10){"0"}) {
    fun greeting() = println("Приветствуем!")

    fun addPerson() {
        catalog = createList(catalog)
    }

    private fun createList(list: MutableList<String>): MutableList<String> {
        while (list.contains("0")) {
            println("Введите имя:")
            val firstName: String = readLine().orEmpty().takeIf{it.isNotBlank()}?: throw MyException("Имя не может быть пустым")
            println("Введите фамилию:")
            val lastName: String = readLine().orEmpty().takeIf{it.isNotBlank()}?: throw MyException("Фамилия не может быть пустым")
            var decision1 = "1"
            loop@do {
                println("Введите номер позиции из тех, которые свободны:")
                println("Свободные позиции: ${list.indices.filter { list[it] == "0" }.map{it + 1}}")
                val number = readLine()?.toIntOrNull()?: continue
                require(number in 1..10) { "Номер позиции может быть только целым числом, не превышающим 10." }
                if (list[number - 1] == "0") {
                    list[number - 1] = firstName + " " + lastName
                    break@loop
                } else {
                    println("Место $number занято. Введите \"1\", чтобы указать другую позицию или введите \"0\", чтобы выйти.")
                    decision1 = readLine().orEmpty()
                }
            } while (decision1 != "0")
            println("Если хотите добавить еще человека, введите \"1\", если нет - \"0\":")
            val decision = readLine().orEmpty()
            if (decision == "0") break
        }
        return list
    }
}