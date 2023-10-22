package brute_force

class 피로도 {

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)
        var max = 0

        fun dfs(rest: Int, count: Int) {
            for (i: Int in dungeons.indices) {
                if (!visited[i] && rest >= dungeons[i][0]) {
                    visited[i] = true
                    dfs(rest - dungeons[i][1], count + 1)
                    visited[i] = false
                }
            }
            max = max.coerceAtLeast(count)
        }

        dfs(k, max)
        return max
    }


}