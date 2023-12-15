package lv2

fun main() {
    tailrec fun tailRecursive(
        length: Int,
        index: Int,
        elements: IntArray,
        result: MutableSet<Int>,
    ): Set<Int> = when (length) {
        elements.size -> result
        else -> {
            when (index) {
                elements.size -> tailRecursive(
                    length = length + 1,
                    index = 0,
                    elements = elements,
                    result = result,
                )

                else -> {
                    val sum = (0..length).toList().fold(0) { acc, i ->
                        acc + elements[
                            index + i - (
                                    if (index + i >= elements.size) elements.size
                                    else 0
                            )
                        ]
                    }

                    result.add(sum)
                    tailRecursive(
                        length = length,
                        index = index + 1,
                        elements = elements,
                        result = result,
                    )
                }
            }
        }
    }

    fun solution(elements: IntArray): Int = tailRecursive(
        length = 0,
        index = 0,
        elements = elements,
        result = mutableSetOf(),
    ).count()

    println(
        solution(
            intArrayOf(7, 9, 1, 1, 4),
        )
    )

}