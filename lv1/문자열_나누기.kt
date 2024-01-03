package lv1

fun main() {
    tailrec fun recursive(
        s: String,
        start: Int,
        index: Int,
        firstCount: Int,
        otherCount: Int,
        count: Int,
    ): Int = when (index != s.length) {
        true -> {
            var copyFirstCount = firstCount
            var copyOtherCount = otherCount
            var copyStart = start
            var copyCount = count

            if (s[start] == s[index]) copyFirstCount++
            else copyOtherCount++

            if (copyFirstCount == copyOtherCount) {
                copyFirstCount = 0
                copyOtherCount = 0
                copyStart = index + 1
                copyCount++
            }

            recursive(
                s = s,
                start = copyStart,
                index = index + 1,
                firstCount = copyFirstCount,
                otherCount = copyOtherCount,
                count = copyCount,
            )
        }

        false -> when(firstCount == otherCount) {
            true -> count
            false -> count + 1
        }
    }

    fun solution(s: String): Int = recursive(
        s = s,
        start = 0,
        index = 0,
        firstCount = 0,
        otherCount = 0,
        count = 0
    )


    println(
//        solution("banana"),
//        solution("abracadabra"),
        solution("aaabbaccccabba"),
    )


}