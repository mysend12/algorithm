package sort

class H_Index {

    fun solution(citations: IntArray): Int {
        citations.sortDescending()

        var result = 0
        for (index in citations.indices) {
            if (index + 1 <= citations[index]) {
                result = index + 1
            }
        }
        return result
    }
}