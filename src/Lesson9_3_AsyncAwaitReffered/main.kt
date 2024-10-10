package Lesson9_3_AsyncAwaitReffered

import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

suspend fun main() = runBlocking {
    val time = measureTimeMillis {
        val numbersList = getRandomNumbersList()
        val charsList = getRandomCharsList()

        val job = launch {
            val numbersUnpack = async() { println("Количество элементов первого спика: ${unpack(numbersList)}") }
            val charsUnpack = async() { println("Количество элементов второго спика: ${unpack(charsList)}") }

            numbersUnpack.start()
            charsUnpack.start()
        }
        job.join()

        val concatenatedLists = concatenate(numbersList, charsList)
        println(concatenatedLists.first)
        println(concatenatedLists.second)
    }

    println("Затрачено времени: $time мс.")
}

fun getRandomNumbersList(): List<Int> {
    return List(10) { Random.nextInt(0, 101) }
}

fun getRandomCharsList(): List<Char> {
    return List(10) { (('a'..'z') + ('A'..'Z')).random() }
}

suspend fun <T> unpack(list: List<T>): Int {
    for (i in list.indices) {
        println("Элемент списка: ${list[i]}, количество элементов: ${i + 1}")
        delay(1000L)
    }
    return list.size
}

fun <T> concatenate(list1: List<T>, list2: List<T>): Pair<Int, MutableList<T>> {
    val resultList: MutableList<T> = mutableListOf()
    resultList.addAll(list1)
    resultList.addAll(list2)
    return Pair(resultList.size, resultList)
}