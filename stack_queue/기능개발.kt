package stack_queue

class 기능개발 {

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var count = 1
        var prevRestDay = -1.0
        val result = mutableListOf<Int>()

        for (index in progresses.indices) {
            val restPercentage = 100 - progresses[index]
            val restDay = kotlin.math.ceil((restPercentage.toDouble() / speeds[index]))

            if (index == 0) {
                prevRestDay = restDay
            } else if (prevRestDay >= restDay) {
                count++
            } else {
                result.add(count)
                prevRestDay = restDay
                count = 1
            }
        }
        result.add(count)
        return result.toIntArray()
    }


}