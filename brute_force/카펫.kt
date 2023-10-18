package brute_force

class 카펫 {

    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow

        var height = 3
        while (true) {
            if (sum % height != 0) {
                height++
                continue
            }

            val width = sum / height
            if (yellow == ((width - 2) * (height - 2))) {
                return intArrayOf(width, height)
            }

            height++
        }
    }



}