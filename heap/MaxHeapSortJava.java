package heap;

public class MaxHeapSortJava {

    public int[] heapSort(int[] heap) {
        buildMaxHeap(heap);
        for (int i = heap.length - 1; i >= 1; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            maxHeapify(heap, 0, i - 1);
        }
        return heap;
    }

    private void buildMaxHeap(int[] heap) {
        for (int i = (heap.length / 2) - 1; i >= 0; i--) {
            maxHeapify(heap, i, -1);
        }
    }

    private void maxHeapify(
            int[] heap,
            int rootIndex,
            int heapSize
    ) {
        heapSize = heapSize == -1 ? heap.length - 1 : heapSize;
        int leftChildIndex = (2 * rootIndex) + 1;
        int rightChildIndex = (2 * rootIndex) + 2;
        int largestElementIndex = rootIndex;

        if (leftChildIndex <= heapSize && heap[leftChildIndex] > heap[rootIndex]) {
            largestElementIndex = leftChildIndex;
        }
        if (rightChildIndex <= heapSize && heap[rightChildIndex] > heap[largestElementIndex]) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != rootIndex) {
            int temp = heap[rootIndex];
            heap[rootIndex] = heap[largestElementIndex];
            heap[largestElementIndex] = temp;
            maxHeapify(heap, largestElementIndex, heapSize);
        }
    }


}
