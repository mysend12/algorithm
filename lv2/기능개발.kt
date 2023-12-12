package lv2


fun main() {
    solution(
//        intArrayOf(93, 30, 55), intArrayOf(1, 30, 5),
        intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1),
    ).forEach { println(it) }
}


fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    val restDay = restDay(
        index = 0,
        progresses = progresses,
        speeds = speeds,
    )

    return recursive(
        index = 1,
        progresses = progresses,
        speeds = speeds,
        result = mutableListOf(),
        maxDay = restDay,
        count = 1,
    ).toIntArray()
}

private tailrec fun recursive(
    index: Int,
    progresses: IntArray,
    speeds: IntArray,
    result: MutableList<Int>,
    maxDay: Int,
    count: Int,
): List<Int> = when (index == progresses.size) {
    true -> {
        result.add(count)
        result
    }

    false -> {
        val restDay = restDay(
            index = index,
            progresses = progresses,
            speeds = speeds,
        )

        if (maxDay < restDay) {
            result.add(count)
            recursive(
                index = index + 1,
                progresses = progresses,
                speeds = speeds,
                result = result,
                maxDay = restDay,
                count = 1,
            )
        } else {
            recursive(
                index = index + 1,
                progresses = progresses,
                speeds = speeds,
                result = result,
                maxDay = maxDay,
                count = count + 1,
            )
        }

    }
}

private fun restDay(
    index: Int,
    progresses: IntArray,
    speeds: IntArray,
): Int {
    val restPercentage = 100 - progresses[index]
    return restPercentage / speeds[index] + (
            if (restPercentage % speeds[index] == 0) 0
            else 1
            )
}