package lv2


fun main() {
    println(solution(8, 4, 7))
}

fun solution(n: Int, a: Int, b: Int): Int = recursion(a, b, 0)
private tailrec fun recursion(a: Int, b: Int, count: Int): Int = when (a == b) {
    true -> count
    false -> {
        recursion(
            if (a % 2 == 1) (a + 1) / 2 else a / 2,
            if (b % 2 == 1) (b + 1) / 2 else b / 2,
            count + 1
        )
    }
}