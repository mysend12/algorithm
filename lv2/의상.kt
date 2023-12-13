package lv2

fun main() {
    fun solution(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }
            .map { it.value.size }
            .fold(1) { acc, i -> acc * (i + 1) } - 1
    }

    println(
        solution(
//            arrayOf(
//                arrayOf("yellow_hat", "headgear"),
//                arrayOf("blue_sunglasses", "eyewear"),
//                arrayOf("green_turban", "headgear"),
//            )
            arrayOf(
                arrayOf("crow_mask", "face"),
                arrayOf("blue_sunglasses", "face"),
                arrayOf("green_turban", "face"),
            )
        )
    )
}