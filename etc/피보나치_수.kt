package etc

fun main() {
    println(solution(2))
}

fun solution(n: Int): Int {
    val array = IntArray(n + 1)
    return fibonacci(array, n)
}

private fun fibonacci(array: IntArray, n: Int): Int = when {
    array[n] != 0 -> array[n]
    n <= 2 -> {
        array[n] = 1
        array[n]
    }
    else -> {
        array[n] = (fibonacci(array, n - 1) + fibonacci(array, n - 2)) % 1234567
        array[n]
    }
}
