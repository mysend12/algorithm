package lv2
import java.util.*

fun main() {
    class Solution {
        tailrec fun tailRecursive(
            levels: MutableMap<Int, Int>,
            queue: LinkedList<Int>,
            location: Int,
            count: Int,
            max: Int,
        ): Int = when (location == 0 && max == queue[location]) {
            true -> count + 1
            false -> {
                val number = queue.pop()
                val result = if (number == max) {
                    levels[number] = levels[number]!!.minus(1)
                    count + 1
                } else {
                    queue.add(number)
                    count
                }

                if (levels[number] == 0) levels.remove(number)

                tailRecursive(
                    levels = levels,
                    queue = queue,
                    location = if (location == 0) queue.size - 1 else location - 1,
                    count = result,
                    max = levels.keys.maxOrNull() ?: 0,
                )
            }
        }

        fun solution(priorities: IntArray, location: Int): Int {
            val queue = LinkedList<Int>()
            val levels = mutableMapOf<Int, Int>()

            priorities.forEach {
                queue.add(it)
                levels[it] = levels[it]?.plus(1) ?: 1
            }

            return tailRecursive(
                levels = levels,
                queue = queue,
                location = location,
                count = 0,
                max = levels.keys.maxOrNull() ?: 0,
            )
        }
    }

}