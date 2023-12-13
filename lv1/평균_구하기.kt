package lv1



fun main() {
    tailrec fun recrusion(sum: Double, arr: IntArray, index: Int): Double = when (index) {
        arr.size -> sum / arr.size
        else -> recrusion(sum + arr[index], arr, index + 1)
    }
    fun solution(arr: IntArray): Double = recrusion(0.0, arr, 0)
}
