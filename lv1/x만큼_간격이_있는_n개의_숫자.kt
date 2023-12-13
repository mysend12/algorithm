package lv1

fun main() {
    tailrec fun recursion(x: Int, n: Int, index: Int, array: LongArray): LongArray = when (n == 0) {
        true -> array
        false -> {
            array[index] = array[index - 1] + x
            recursion(x, n - 1, index + 1, array)
        }
    }

    fun solution(x: Int, n: Int): LongArray {
        val array = LongArray(n)
        array[0] = x.toLong()
        return recursion(x, n - 1, 1, array)
    }

    solution(-4, 2).forEach { println(it) }
}


