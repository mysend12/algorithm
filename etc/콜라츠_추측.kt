package etc

class 콜라츠_추측 {
    fun solution(num: Int): Int {
        if (num == 1) return 0
        return recursion(num.toLong(), 0)
    }

    private tailrec fun recursion(num: Long, count: Int): Int = when {
        num == 1L -> count
        count >= 500 -> -1
        num % 2 == 0L -> recursion(num / 2, count + 1)
        else -> recursion(num * 3 + 1, count + 1)
    }
}