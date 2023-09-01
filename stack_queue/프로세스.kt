package stack_queue

class 프로세스 {

    fun solution(priorities: IntArray, location: Int): Int {
        var count = 0

        var lastIndex = -1
        for ((index, number) in priorities.withIndex()) {
            if (priorities[index] == 9) {
                lastIndex = index
                count++
                if (lastIndex == location) return count
            }
        }

        for (number: Int in 8 downTo 1) {
            var jLastIndex = -1
            for (jIndex: Int in lastIndex + 1 until priorities.size) {
                if (priorities[jIndex] == number) {
                    jLastIndex = jIndex
                    count++
                    if (jLastIndex == location) return count
                }
            }
            for (jIndex: Int in 0..lastIndex) {
                if (priorities[jIndex] == number) {
                    jLastIndex = jIndex
                    count++
                    if (jLastIndex == location) return count
                }
            }
            lastIndex = if (jLastIndex == -1) lastIndex
            else jLastIndex
        }

        return count
    }
}