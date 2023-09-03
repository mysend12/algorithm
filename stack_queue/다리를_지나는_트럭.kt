package stack_queue

import java.util.LinkedList

class 다리를_지나는_트럭 {

    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        // first: index, second: truckWeight
        val popIndexesAndTruckWeight: MutableList<Pair<Int, Int>> = LinkedList()

        var currentIndex = 0
        var sumWeight = 0

        for (truckWeight in truck_weights) {
            var infinityLoop = true

            while (infinityLoop) {
                popIndexesAndTruckWeight.firstOrNull()?.let { pair ->
                    if (pair.first == currentIndex) {
                        sumWeight -= popIndexesAndTruckWeight.removeFirst().second
                    }
                }

                if (sumWeight + truckWeight <= weight) {
                    sumWeight += truckWeight
                    popIndexesAndTruckWeight.add(currentIndex + bridge_length to truckWeight)
                    infinityLoop = false
                }

                currentIndex++
            }
        }

        popIndexesAndTruckWeight.lastOrNull()?.first?.let { popIndex ->
            if (currentIndex < popIndex) return popIndex + 1
        }
        return currentIndex
    }
}