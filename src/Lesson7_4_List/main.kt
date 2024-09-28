package Lesson7_4_List

fun main() {
    val numbers = listOf(10, 5, 7, 3, 10, 4, 2, 1)
    println(numbers[0])
    println(numbers.first())

    println(numbers.average())
    var summ = 0.0
    var cnt = 0
    for (num in numbers) {
        summ += num
        cnt += 1
    }
    val avg = summ / numbers.size
    println(avg)

    println(numbers.sum())
    println(summ)

    println(numbers.size)
    println(cnt)

    println(numbers.takeLast(2).sum())
    var lastTwoSum = 0
    for (i in (numbers.indices.last - 1) .. numbers.indices.last) {
        lastTwoSum += numbers[i]
    }
    println(lastTwoSum)

    println(numbers.indices.sum())
    var sumOfIndices = 0
    for (i in 0 .. numbers.indices.last) {
        sumOfIndices += i
    }
    println(sumOfIndices)
}