package lv1

fun main() {
    tailrec fun recursive(
        price: Int,
        count: Int,
        index: Int,
        result: Long,
    ): Long = when (count == index) {
        false -> recursive(price, count, index + 1, price * index + result)
        true -> price * index + result

    }
    fun solution(price: Int, money: Int, count: Int): Long = recursive(price, count, 1, 0) - money

    println(
        solution(3, 20, 4)
    )
}