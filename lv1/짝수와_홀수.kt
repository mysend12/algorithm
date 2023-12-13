package lv1

fun main() {
    fun solution(num: Int): String = when (num % 2 === 0) {
        true -> "Even"
        false -> "Odd"

    }
    println(solution(4))
}
