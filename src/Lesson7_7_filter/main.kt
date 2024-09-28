package Lesson7_7_filter

fun main() {
    val map = mapOf(
        1 to "Lena",
        2 to "Ivan",
        3 to "Denis",
        4 to "Ruslan",
        5 to "Nadia",
        6 to "Fedor",
        7 to "Oleg",
        8 to "Gena",
        9 to "Goga")
    println(map.filter{it.key >= 5})
    println(map.filter{it.value.last() == 'a'})
    println(map.filter{it.value.startsWith('G')})

    val prizeMap = mapOf(
        1001 to 10,
        1002 to 20,
        1003 to 50,
        1005 to 15,
        1006 to 60,
        1015 to 30,
        1020 to 10
    )
    println(prizeMap.filter{(it.key % 10 == 5) && (it.value >= 20)})
}