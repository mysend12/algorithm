package heap

import java.util.*

class 이중우선순위큐 {
    fun solution(operations: Array<String>): IntArray {
        val minHeap: PriorityQueue<Int> = PriorityQueue()
        val maxHeap: PriorityQueue<Int> = PriorityQueue(compareByDescending { it })

        operations.forEach { operation ->
            if (operation.startsWith("I ")) {
                val number = operation.removeRange(0, 2).toInt()
                minHeap.add(number)
                maxHeap.add(number)
            } else if (operation == "D 1") {
                val element = maxHeap.poll()
                element?.let {
                    minHeap.remove(element)
                }
            } else if (operation == "D -1") {
                val element = minHeap.poll()
                element?.let {
                    maxHeap.remove(element)
                }
            }
        }

        if (minHeap.isEmpty()) return intArrayOf(0, 0)
        else if (minHeap.size == 1) return intArrayOf(0, minHeap.poll())

        return intArrayOf(
            maxHeap.poll(),
            minHeap.poll(),
        )
    }
}