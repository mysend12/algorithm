package greedy

class 체육복 {

    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostSet = lost.toSortedSet()
        val reserveSet = reserve.toSortedSet()

        reserveSet.removeIf { reserveStudent ->
            lostSet.remove(reserveStudent)
        }
        var count = n - lostSet.size

        reserveSet.forEach { reserveStudent ->
            if (lostSet.isEmpty()) return@forEach
            else if (lostSet.remove(reserveStudent - 1) || lostSet.remove(reserveStudent + 1)) {
                count++
            }
        }

        return count
    }

}