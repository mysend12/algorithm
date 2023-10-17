package brute_force

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
        val sieveOfEratosthenes = sieveOfEratosthenes(max)
        return set.count { sieveOfEratosthenes[it] }
    }


    private fun sieveOfEratosthenes(max: Int): BooleanArray {
        val list = BooleanArray(max + 1)
        if (max <= 2) return list
        for (index: Int in 2..max) {
            list[index] = true
        }

        for (index in 2 until max) {
            if (index * index > max) return list
            if (list[index]) {
                for (jIndex in (index * index)..max step index) {
                    list[jIndex] = false
                }
            }
        }

        return list
    }

}