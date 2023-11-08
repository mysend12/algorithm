package etc

class 나머지가_1이_되는_수_찾기 {

    fun solution(n: Int): Int {
        return loop(n, 2)
    }

    private tailrec fun loop(n: Int, x: Int): Int = when {
        n % x == 1 -> x
        else -> loop(n, x + 1)
    }
}