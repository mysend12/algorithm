package etc

fun main() {
    println(
        최소직사각형().solution(
            arrayOf(
//            intArrayOf(60, 50),
//            intArrayOf(30, 70),
//            intArrayOf(60, 30),
//            intArrayOf(80, 40),

//            intArrayOf(10, 7),
//            intArrayOf(12, 3),
//            intArrayOf(8, 15),
//            intArrayOf(14, 7),
//            intArrayOf(5, 15),

//            [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
                intArrayOf(14, 4),
                intArrayOf(19, 6),
                intArrayOf(6, 16),
                intArrayOf(18, 7),
                intArrayOf(7, 11),
            )
        )
    )
}

class 최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int = sort(sizes, intArrayOf(0, 0), 0).let { it[0] * it[1] }

    private tailrec fun sort(sizes: Array<IntArray>, result: IntArray, index: Int): IntArray = when (sizes.size) {
        index -> result
        else -> {
            val min = sizes[index][0].coerceAtMost(sizes[index][1])
            val max = sizes[index][0].coerceAtLeast(sizes[index][1])
            sizes[index][0] = min
            sizes[index][1] = max

            result[0] = min.coerceAtLeast(result[0])
            result[1] = max.coerceAtLeast(result[1])

            sort(sizes, result, index + 1)
        }
    }
}