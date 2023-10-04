package brute_force

class 최소직사각형 {

    fun solution(sizes: Array<IntArray>): Int {
        var maxWidth = 0
        var maxHeight = 0

        sizes.forEach { (width, height) ->
            val max = width.coerceAtLeast(height)
            val min = width.coerceAtMost(height)

            if (maxWidth < max) {
                maxWidth = max
            }
            if (maxHeight < min) {
                maxHeight = min
            }
        }
        return maxWidth * maxHeight
    }
}