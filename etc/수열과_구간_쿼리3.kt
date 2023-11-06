package etc

class 수열과_구간_쿼리3 {

    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        queries.forEach { (x: Int, y: Int) ->
            val temp = arr[x]
            arr[x] = arr[y]
            arr[y] = temp
        }
        return arr
    }
}