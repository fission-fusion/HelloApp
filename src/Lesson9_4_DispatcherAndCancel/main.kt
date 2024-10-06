package Lesson9_4_DispatcherAndCancel

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main() = runBlocking {
    println("Программа работы с базой данных сотрудников")
    delay(1000L)
    val manager = PersonManager()
    println("Добавить сотрудника:\n1.Да\n2.Нет")
    val firstInput = readLine()
    if (firstInput == "1") {
        addPersonToManager(manager)
        while (true) {
            println("Добавить сотрудника:\n1.Да\n2.Прочитать базу данных")
            val secondInput = readLine()
            if (secondInput == "1") {
                addPersonToManager(manager)
            } else if (secondInput == "2") {
                break
            }
        }
    } else println("Вы вышли из программы")
    withContext(Dispatchers.IO) {
        val job = launch {
            manager.addPassword()
            manager.readDataPersonList()
        }
        val job2 = launch {
            while (true) {
                val thirdInput = readLine()
                if (thirdInput == "0") {
                    println("Завершение полной работы")
                    job.cancelAndJoin()
                    break
                }
            }
        }
    }
    println("end")
}

data class Person(val name: String, val salary: Int) {
}

class PersonManager() {
    private val personList: MutableList<Person> = mutableListOf()
    private val resultMap: MutableMap<Person, Int> = mutableMapOf()

    fun addPerson(person: Person) {
        personList.add(person)
    }

    suspend fun addPassword() {
        for (i in personList.indices) {
            delay(500L)
            val password = Random.nextInt(100000, 1000000)
            resultMap[personList[i]] = password
        }

    }

    suspend fun readDataPersonList() {
        for (i in resultMap) {
            println("Сотрудник: ${i.key}; пароль: ${i.value}")
            delay(1000L)
        }
    }
}

fun addPersonToManager(manager: PersonManager) {
    println("Введите имя сотрудника:")
    val name = readLine() ?: "Нет имени"
    println("Введите зарплату сотрудника:")
    val salary = readLine()?.toInt() ?: 0
    manager.addPerson(Person(name, salary))
}