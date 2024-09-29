package lesson8_5_sort

fun main() {
    val employees = listOf(
        Employee("Иван", 28, 30000),
        Employee("Илья", 27, 50000),
        Employee("Игорь", 29, 40000),
        Employee("Дарья", 25, 50000),
        Employee("Жанна", 29, 30000)
    )

    println(employees.sorted())
    println(employees.sortedBy {it.name})
    println(employees.sortedWith { e1: Employee, e2: Employee -> e1.age - e2.age})
    println(employees.sortedWith(compareBy {it.salary} ))

    val matrix = listOf(
        listOf(7, 8, 9, 1),
        listOf(9, 2, 3, 5),
        listOf(4, 6, 1, 2)
    )

    println(matrix.map{ it.sorted() })

    val sawtoothList = sawtoothListFilter(matrix)
    println(sawtoothList)
    println(sawtoothList.size)
}

class Employee(val name: String, val age: Int, val salary: Int): Comparable<Employee> {
    override fun compareTo(other: Employee): Int =
        name.compareTo(other.name)

    override fun toString() = "[$name, $age, $salary]"
}

fun sawtoothListFilter(matrix: List<List<Int>>): List<List<Int>> {
    return matrix.filter{ isSawtoothList(it) }
}

fun isSawtoothList(matrix: List<Int>): Boolean {
    for (n in 1..matrix.size - 2) {
        if (!(((matrix[n] > matrix[n + 1]) && (matrix[n] > matrix[n - 1])) ||
                ((matrix[n] < matrix[n + 1]) && (matrix[n] < matrix[n - 1])))) {
            return false
        }
    }
    return true
}

