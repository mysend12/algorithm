package lv2


fun main() {
    println(
//        solution(6, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
        solution(4, intArrayOf(1, 3, 2, 5, 4, 5, 2, 3))
//        solution(2, intArrayOf(1, 1, 1, 1, 2, 2, 2, 3))
    )
}

fun solution(k: Int, tangerine: IntArray): Int {
    val list = tangerine.groupBy { it }.toList().sortedByDescending { it.second.size }
    return recursion(0, k, 0, list)
}

private tailrec fun recursion(result: Int, k: Int, index: Int, list: List<Pair<Int, List<Int>>>): Int =
    when(index < list.size && k > 0) {
        true -> recursion(result + 1, k - list[index].second.size, index + 1, list)
        false -> result
    }
