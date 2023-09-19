package sort

class K번째수 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val result = IntArray(commands.size)

        commands.forEachIndexed { index, (start, end, targetIndex) ->
            val copyArray = array.copyOfRange(start - 1, end)
            copyArray.sort()
            result[index] = copyArray[targetIndex - 1]
        }

        return result
    }

}