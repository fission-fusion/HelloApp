package Lesson9_1_suspend

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() = coroutineScope {
    val persons = listOf(
        Person("Иван", 30),
        Person("Олег", 33),
        Person("Михаил", 31),
        Person("Артем", 27),
        Person("Илья", 28)
    )

    val weatherList = listOf(
        Weather("Казань", "Ближайшие 2 часа дождя не предвещается", 18),
        Weather("Казань", "Ближайшие 2 часа ожидается ливень", 23),
        Weather("Москва", "Погода солнечная", 10),
        Weather("Москва", "Идет небольшой дождь", 20),
        Weather("Мурманск", "Гололед", -1),
    )

    val randoms = List(10) { Random.nextInt(1, 101)}

    val tasks = listOf(
        launch {
            getServerData(persons)
        },
                launch {
            getServerData(weatherList)
        },
                launch {
            getServerData(randoms)
        }
    )
    tasks.joinAll()

    println("Данные загружены")

    println(persons)
    println(weatherList)
    println(randoms)
    println("Программа завершена")
}

data class Person(val name: String, val age: Int) {
}

data class Weather(val city: String, val description: String, val temp: Int) {
}

private suspend fun <T> getServerData(data: List<T>): List<T> {
    for (i in data) {
        delay(1000L)
        println(i)}
    return data
}