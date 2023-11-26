package lv2

fun main() {
    println(solution(4))
}

fun solution(n: Int): Long = fibonacci(n - 1, LongArray(n))

private fun fibonacci(n: Int, fibonaccies: LongArray): Long = when {
    fibonaccies[n] != 0L -> fibonaccies[n]
    n <= 1 -> {
        fibonaccies[n] = (n + 1).toLong()
        (n + 1).toLong()
    }
    else -> {
        fibonaccies[n] = (fibonacci(n - 1, fibonaccies) + fibonacci(n - 2, fibonaccies)) % 1234567
        fibonaccies[n]
    }
}
