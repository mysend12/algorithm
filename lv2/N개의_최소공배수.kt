package lv2

fun main() {
    println(
        solution(intArrayOf(1, 2, 3))
    )
}


fun solution(arr: IntArray): Int {
    if (arr.size == 1) return arr[0]
    return arr.fold(1) { a, b -> lcm(a, b) }
}

private fun lcm(a: Int, b: Int): Int {
    val gcd = when (a > b) {
        true -> gcd(a, b)
        false -> gcd(b, a)
    }
    return (a * b) / gcd
}

private tailrec fun gcd(a: Int, b: Int): Int = when {
    a % b == 0 -> b
    else -> when (a > b) {
        true -> gcd(b, a % b)
        false -> gcd(a, b % a)
    }
}