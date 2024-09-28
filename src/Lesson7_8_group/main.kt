package Lesson7_8_group

fun main() {
    val words = listOf("line", "animal", "person", "alphabet", "lion", "post")
    println(words.groupBy{it.first()})
    println(words.groupBy{it.length})

    val phoneToYear = mapOf(
        "Nexus One" to 2010,
        "Pixel 2" to 2017,
        "Pixel 4a" to 2020,
        "iPhone 4" to 2010,
        "iPhone X" to 2017,
        "Galaxy Note 8" to 2017,
        "Galaxy S11" to 2020
    )
    println(phoneToYear.entries.map{it.toPair()}.groupBy{it.second})
}