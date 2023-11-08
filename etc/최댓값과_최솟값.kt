package etc

class 최댓값과_최솟값 {
    fun solution(s: String): String {
        val integers = s.split(" ").map { it.toInt() }
        return loop(integers, 1, integers[0], integers[0])
    }

    private tailrec fun loop(integers: List<Int>, index: Int, min: Int, max: Int): String = when {
        index == integers.size -> "$min $max"
        integers[index] < min -> loop(integers, index + 1, integers[index], max)
        integers[index] > max -> loop(integers, index + 1, min, integers[index])
        else -> loop(integers, index + 1, min, max)
    }
}