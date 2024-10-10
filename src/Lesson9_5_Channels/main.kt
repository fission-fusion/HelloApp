package Lesson9_5_Channels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

suspend fun main() {
    val listOfLines = Storage().text.split("\n")
    val stringResult = StringBuilder()

    val time = measureTimeMillis {
        coroutineScope {
            val channel1 = Channel<String>()
            launch {
                getList(listOfLines, channel1)
            }
            launch {
                for (line in channel1) {
                    stringResult.append(line + "\n")}
            }
        }
    }

    println("Затраченное вермя: $time мс.")
    println(stringResult)
}

class Storage() {
    val text = "Мартышка к старости слаба глазами стала;\n" +
            "А у людей она слыхала,\n" +
            "Что это зло еще не так большой руки:\n" +
            "Лишь стоит завести Очки.\n" +
            "Очков с полдюжины себе она достала;\n" +
            "Вертит Очками так и сяк:\n" +
            "То к темю их прижмет, то их на хвост нанижет,\n" +
            "То их понюхает, то их полижет;\n" +
            "Очки не действуют никак.\n" +
            "«Тьфу пропасть! — говорит она, — и тот дурак,\n" +
            "Кто слушает людских всех врак:\n" +
            "Всё про Очки лишь мне налгали;\n" +
            "А проку на-волос нет в них».\n" +
            "Мартышка тут с досады и с печали\n" +
            "О камень так хватила их,\n" +
            "Что только брызги засверкали.\n" +
            "К несчастью, то ж бывает у людей:\n" +
            "Как ни полезна вещь, — цены не зная ей,\n" +
            "Невежда про нее свой толк все к худу клонит;\n" +
            "А ежели невежда познатней,\n" +
            "Так он ее еще и гонит."
}

suspend fun getList(text: List<String>, channel: SendChannel<String>) {
    text.forEach {
        channel.send(it)
        delay(10L)
    }
    channel.close()
}
