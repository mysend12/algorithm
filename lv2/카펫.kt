package lv2

fun main() {
    solution(10, 2).forEach { print(it) }
}

fun solution(brown: Int, yellow: Int): IntArray = recursion(brown, yellow, 1)

/**
 * 브라운 맨 윗줄과 맨 아랫줄은 (노락색 한줄 + 2)
 * 브라운 세로는 노란색 세로
 *
 * 전체 크기가 x * y인 경우,
 * brown = (2 * x) + (2 * (y - 2))
 * yellow = (x-2) * (y -2)
 *
 * brown + yellow == x * y
 * 12 / 1 = 12
 * 12 / 2 = 6
 * 12 / 3 = 4
 *
 */


private tailrec fun recursion(brown: Int, yellow: Int, y: Int): IntArray = when {
    (brown + yellow) % y == 0 && brown == (2 * ((brown + yellow) / y)) + (2 * (y - 2)) -> intArrayOf((brown + yellow) / y, y)
    else -> recursion(brown, yellow, y + 1)
}
//private fun recrusion(brown: Int, yellow: Int, x: Int, y: Int): IntArray {
//    val sum = brown + yellow
//
//    var x = 1
//    var y = 1
//
//    while (x >= y) {
//        if (sum % y == 0) {
//            x = sum / y
//            if (brown == (2 * x) + (2 * (y - 2))) {
//                return intArrayOf(x, y)
//            }
//        }
//        y++
//    }
//    return intArrayOf()
//
//}

