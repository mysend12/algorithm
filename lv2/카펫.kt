package lv2

fun main() {
    solution(10, 2).forEach { print(it) }
}

fun solution(brown: Int, yellow: Int): IntArray = recursion(brown, yellow, 1)

private tailrec fun recursion(brown: Int, yellow: Int, y: Int): IntArray = when {
    (brown + yellow) % y == 0 && brown == (2 * ((brown + yellow) / y)) + (2 * (y - 2)) -> intArrayOf((brown + yellow) / y, y)
    else -> recursion(brown, yellow, y + 1)
}
