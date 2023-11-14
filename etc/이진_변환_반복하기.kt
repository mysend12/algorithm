package etc

fun main() {
//    println("110010101001".toLong())
    이진_변환_반복하기().solution("1111111").forEach { println(it) }
}
class 이진_변환_반복하기 {

    fun solution(s: String): IntArray = recursion(s, 0, 0)

    private tailrec fun recursion(binaryString: String, index: Int, removeZeroCount: Int): IntArray = when (binaryString == "1") {
        true -> intArrayOf(index, removeZeroCount)
        false -> {
            val copyRemoveZeroCount = removeZeroCount + binaryString.count { c -> c == '0' }
            recursion(
                binaryString = Integer.toBinaryString(binaryString.filter { c -> c == '1' }.length),
                index = index + 1,
                removeZeroCount = copyRemoveZeroCount,
            )
        }
    }
}