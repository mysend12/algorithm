package brute_force

class 모의고사 {
    fun solution(answers: IntArray): IntArray {
        val arrays = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5),
        )

        var first = 0
        var second = 0
        var third = 0

        for (i: Int in answers.indices) {
            if (arrays[0][i % 5] == answers[i]) first++
            if (arrays[1][i % 8] == answers[i]) second++
            if (arrays[2][i % 10] == answers[i]) third++
        }

        val max = first.coerceAtLeast(second).coerceAtLeast(third)
        val result = mutableListOf<Int>()
        if (max == first) result.add(1)
        if (max == second) result.add(2)
        if (max == third) result.add(3)
        return result.toIntArray()
    }
}