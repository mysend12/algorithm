package etc

class 소수_판별 {

    fun isPrime(x: Int): Boolean {
        for (i in 2 until x) {
            if (x % i == 0) return false
        }
        return true
    }

    fun sieveOfEratosthenes(max: Int): BooleanArray {
        val list = BooleanArray(max + 1)
        if (max <= 2) return list
        for (index: Int in 2..max) {
            list[index] = true
        }

        for (index in 2 until max) {
            if (index * index > max) return list
            if (list[index]) {
                for (jIndex in (index * index)..max step index) {
                    list[jIndex] = false
                }
            }
        }

        return list
    }
}