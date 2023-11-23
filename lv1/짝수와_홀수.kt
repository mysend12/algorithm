package lv1

fun main() {
    println(solution(4))
}

fun solution(num: Int): String = when(num % 2 === 0) {
    true -> "Even"
    false -> "Odd"
}
