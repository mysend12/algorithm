package lv2

fun main() {
    tailrec fun tailRecursive(
        n: Int,
        index: Long,
        result: IntArray,
        left: Long,
        right: Long,
    ): IntArray = when (index in left..right) {
        true -> {
            val x = index / n
            val y = index % n
            result[(index - left).toInt()] = if (x >= y) (x + 1).toInt() else (y + 1).toInt()
            tailRecursive(
                n = n,
                index = index + 1,
                result = result,
                left = left,
                right = right,
            )
        }

        false -> result
    }

    fun solution(n: Int, left: Long, right: Long): IntArray = tailRecursive(
        n = n,
        index = left,
        result = IntArray(size = (right - left + 1).toInt(), init = { i -> i }),
        left = left,
        right = right,
    )

    solution(
        n = 3, left = 2, right = 5
//        n = 4, left = 7, right = 14
    ).forEach { print("$it,") }
}