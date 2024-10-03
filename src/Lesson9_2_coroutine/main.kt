package Lesson9_2_coroutine

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {
    task1()
    //task2()
}

suspend fun task1() = coroutineScope {
    val job = launch {
        delay(1000L)
        println("Купить товар:\n1.Да\n2.Нет")
        val input = readLine()
        if (input == "1") {
            launch {
                println("Оплата продукта началась")
                delay(2000L)
                println("Сканирование и обработка...")
                delay(2000L)
                println("Покупка оплачена.")
            }
        } else if (input == "2") {
            launch {
                println("Отмена покупки...")
                delay(2000L)
                println("Покупка отменена.")
            }
        } else throw Error("Требуется ввод 1 или 2")
    }
    println("Программа покупки продуктов")
    job.join()
    println("До свидания")
}

suspend fun task2() = runBlocking {
    println("Начало программы")
    val job = launch {
        for (i in 1..4) {
            println(i)
            delay(1000L)
        }
    }
    val job2 = launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("Произошел ленивый запуск")
    }
    val job3 = launch(start = CoroutineStart.LAZY) {
        delay(4000L)
        println("Программа завершена")
    }
    job3.start()
    job2.start()
    job.join()
}