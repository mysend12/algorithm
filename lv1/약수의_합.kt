package lv1


fun main() {
    tailrec fun recursion(
        n: Int,
        index: Int,
        sum: Int,
    ): Int = when (index) {
        n / 2 + 1 -> sum + n
        else -> recursion(
            n = n,
            index = index + 1,
            sum = if (n % index == 0) {
                sum + index
            } else sum,
        )
    }

    fun solution(n: Int): Int = recursion(
        n = n,
        index = 1,
        sum = 0,
    )
    println(
        solution(5)
    )
}

