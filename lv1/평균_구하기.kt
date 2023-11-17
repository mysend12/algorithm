package lv1

fun solution(arr: IntArray): Double = recrusion(0.0, arr, 0)
private tailrec fun recrusion(sum: Double, arr: IntArray, index: Int, ): Double = when(index) {
    arr.size -> sum / arr.size
    else -> recrusion(sum + arr[index], arr, index + 1)
}
