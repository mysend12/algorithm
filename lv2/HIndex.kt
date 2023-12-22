package lv2


fun main() {
    tailrec fun tailRecursive(
        index: Int,
        count: Int,
        citations: IntArray,
    ): Int = when (count < citations[index]) {
        true -> {
            if (index == 0) count + 1
            else tailRecursive(
                index = index - 1,
                count = citations.size - index,
                citations = citations,
            )
        }

        false -> count
    }

    fun solution(citations: IntArray): Int {
        citations.sort()
        if (citations[citations.size - 1] == 0) return 0
        return tailRecursive(
            index = citations.size - 1,
            count = 1,
            citations = citations,
        )
    }

    solution(intArrayOf(0, 0, 0, 0, 0))
}