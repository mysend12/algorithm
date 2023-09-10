package heap

class MaxHeapSort {
    /**
     * 최대 힙 트리나 최소 힙 트리를 구성해 정렬하는 방법
     * 내림차순 정렬을 위해 최대 힙 구성
     * 오름차순 정렬을 휘애 최소 힙 구성
     *
     * 최대 힙으로 만드는 과정 -> O(log n)
     * 최종 힙 정렬 -> O(n log n)
     *
     * 특징: 제자리 정렬으로, 정렬을 위한 추가적인 메모리가 필요하지 않다.
     * 최선 & 평균 & 최악의 경우 모두 heapify과정이 필요하여 n log n을 보장한다.
     * 데이터의 순서를 보장하지 못하는 불안정 정렬이다.
     *
     * 퀵 정렬과 비교하면, 같은 n log n이지만 퀵 정렬이 더 빠르다.
     * 이유는 힙정렬의 원소가 더 흩어져있어 캐시 친화도가 떨어지며, 포인터 연산을 많이 사용하여
     * 여기에 걸리는 오버헤드가 있기 때문이다.
     */
    fun heapSort(heap: IntArray): IntArray {
        buildMaxHeap(heap)

        for (i in heap.size - 1 downTo 1) {
            val temp = heap[0]
            heap[0] = heap[i]
            heap[i] = temp
            maxHeapify(heap, 0, i - 1)
        }
        return heap
    }

}

private fun buildMaxHeap(array: IntArray) {

    for (i in ((array.size/2) - 1) downTo 0) {
        maxHeapify(array, i)
    }

}

private fun maxHeapify(array: IntArray, rootIndex: Int, heapSize: Int = array.size - 1) {

    val leftChildIndex = (2 * rootIndex) + 1
    val rightChildIndex = (2 * rootIndex) + 2
    var largestElementIndex = rootIndex

    if (leftChildIndex <= heapSize && array[leftChildIndex] > array[rootIndex]) {
        largestElementIndex = leftChildIndex
    }

    if (rightChildIndex <= heapSize && array[rightChildIndex] > array[largestElementIndex]) {
        largestElementIndex = rightChildIndex
    }

    if (largestElementIndex != rootIndex) {
        val temp = array[rootIndex]
        array[rootIndex] = array[largestElementIndex]
        array[largestElementIndex] = temp
        maxHeapify(array, largestElementIndex, heapSize)
    }

}