package greedy

class 조이스틱 {
    fun solution(name: String): Int {
        val start = 'A'.code
        val end = 'Z'.code

        var checkCount = 0
        val visited = BooleanArray(name.length)
        for ((index, c) in name.withIndex()) {
            if (c == 'A') {
                visited[index] = true
                checkCount++
            }
        }

        var index = 0
        var count = 0

        while (checkCount != name.length) {
            if (visited[index]) {
                var plusCopyIndex = index
                var plusMoveCount = 0
                while (visited[plusCopyIndex]) {
                    if (plusCopyIndex == name.length) {
                        plusMoveCount++
                        plusCopyIndex = 0
                    } else {
                        plusCopyIndex++
                        plusMoveCount++
                    }
                }

                var minusCopyIndex = index
                var minusMoveCount = 0
                while (visited[minusCopyIndex]) {
                    if (minusCopyIndex == 0) {
                        minusMoveCount++
                        minusCopyIndex = name.length - 1
                    } else {
                        minusCopyIndex--
                        minusMoveCount++
                    }
                }
                if (plusMoveCount <= minusMoveCount) {
                    index = plusCopyIndex
                    count += plusMoveCount
                } else {
                    index = minusCopyIndex
                    count += minusMoveCount
                }
            } else {
                checkCount++
                visited[index] = true
                count += (name[index].code - start)
                    .coerceAtMost((end - name[index].code) + 1)
            }
        }

        return count
    }
}