package brute_force

import etc.소수_판별

class 소수_찾기 {
    fun solution(numbers: String): Int {
        val set = mutableSetOf<Int>()
        val visited = BooleanArray(numbers.length).toTypedArray()
        val part = numbers.split("").filter { it.isNotBlank() }.toTypedArray()
        var max = 0

        fun permutation(index: Int, sum: String) {
            if (sum.isNotEmpty()) {
                val sumToInt = sum.toInt()
                set.add(sumToInt)
                if (sumToInt > max) max = sumToInt
            }

            for (i: Int in part.indices) {
                if (!visited[i]) {
                    visited[i] = true
                    permutation(index + 1, sum + part[i])
                    visited[i] = false
                }
            }
        }

        permutation(0, "")
        val sieveOfEratosthenes = 소수_판별().sieveOfEratosthenes(max)
        return set.count { sieveOfEratosthenes[it] }
    }

}