package etc


fun main() {
    println(
        없는_숫자_더하기().solution(
//            intArrayOf(1, 2, 3, 4, 6, 7, 8, 0)
            intArrayOf(5, 8, 4, 0, 6, 7, 9)
        )
    )



}


class 없는_숫자_더하기 {
    fun solution(numbers: IntArray): Int = sumNotHaveNumbers(0, 1, numbers.toSet())

    private tailrec fun sumNotHaveNumbers(sum: Int, index: Int, set: Set<Int>): Int = when {
        index == 10 -> sum
        set.contains(index) -> sumNotHaveNumbers(sum, index + 1, set)
        else -> sumNotHaveNumbers(index + sum, index + 1, set)
    }


}