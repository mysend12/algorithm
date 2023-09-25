package sort

class 가장_큰_수 {

    fun solution(numbers: IntArray): String {
        var array = arrayOf<String>()
        numbers.forEach { array += it.toString() }

        array.sortWith { o1, o2 ->
            when (o1.length) {
                o2.length -> o2.compareTo(o1)
                else -> (o2 + o1).compareTo(o1 + o2)
            }
        }
        if (array[0] == "0") return "0"
        return array.joinToString(separator = "") {it}

//        val array = numbers.sortWith(Comparator<String> { o1, o2 ->
//            when (o1.toString().length) {
//                o2.toString().length -> o2.compareTo(o1)
//                else -> (o2.toString() + o1.toString()).compareTo(o1.toString() + o2.toString())
//            }
//        }

//            if (array[0] == "0") {
//                return "0"
//            }

//        return numbers.sortedByDescending { number ->
//            number.toString().length
//            val numString = number.toString() + number.toString() + number.toString()
//            // TODO 89, 898 -> 898989, 898898898 -> 898, 898로 동일해진다는 문제가 해결 필요
//
//            numString.substring(0, 3).toInt()
//        }.joinToString(separator = "") { it.toString() }
    }

//    val comparator = Comparator<Int> { a, b ->
//        val aNumString = a.toString() + a.toString() + a.toString()
//        val bNumString = b.toString()
//
//        val first = aNumString.substring(0, 3).toInt()
//        val second = bNumString.substring(0, 3).toInt()
//
//    }
}