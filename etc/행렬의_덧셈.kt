package etc

class 행렬의_덧셈 {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        return loop(
            result = mutableListOf(),
            arr1 = arr1,
            arr2 = arr2,
            index = 0,
        )
    }

    private tailrec fun loop(
        result: MutableList<IntArray>,
        arr1: Array<IntArray>,
        arr2: Array<IntArray>,
        index: Int,
    ): Array<IntArray> = when {
        arr1.size <= index && arr2.size <= index -> result.toTypedArray()
        arr1.size > index && arr2.size > index -> {
            result.add(loop2(mutableListOf(), arr1[index], arr2[index], 0))
            loop(result, arr1, arr2, index + 1)
        }

        arr1.size > index && arr2.size <= index -> {
            result.add(loop2(mutableListOf(), arr1[index], IntArray(arr1.size), 0))
            loop(result, arr1, arr2, index + 1)
        }

        else -> {
            result.add(loop2(mutableListOf(), arr2[index], IntArray(arr2.size), 0))
            loop(result, arr1, arr2, index + 1)
        }
    }

    private tailrec fun loop2(
        result: MutableList<Int>,
        arr1: IntArray,
        arr2: IntArray,
        index: Int,
    ): IntArray = when {
        arr1.size <= index && arr2.size <= index -> result.toIntArray()
        arr1.size > index && arr2.size > index -> {
            result.add(arr1[index] + arr2[index])
            loop2(result, arr1, arr2, index + 1)
        }
        arr1.size > index && arr2.size <= index -> {
            result.add(arr1[index])
            loop2(result, arr1, arr2, index + 1)
        }
        else -> {
            result.add(arr2[index])
            loop2(result, arr1, arr2, index + 1)
        }
    }
}