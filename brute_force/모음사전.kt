package brute_force

class 모음사전 {
    fun solution(word: String): Int {
        val dictionary = charArrayOf('A', 'E', 'I', 'O', 'U')
        val builder = StringBuilder()

        var count = 0
        val visited = booleanArrayOf(false, false, false, false, false)

        fun dfs(depth: Int) {
            count++
            if (word == builder.toString()) return

            for (index: Int in visited.indices) {
                if (depth == visited.size) return
                builder.append(dictionary[index])
                visited[index] = true
                dfs(depth + 1)
                if (word == builder.toString()) return
                visited[index] = false
                builder.deleteCharAt(builder.length - 1)
            }
        }

        dfs(0)
        return count - 1
    }

}