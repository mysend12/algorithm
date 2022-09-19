package io.my;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAlgorithm {




    @BigONotation(
            bestBigO = "O(N * logN)",
            averageBigO = "O(N * logN)",
            worstBigO = "O(N * logN)",
            description = "병랍 정렬 - 분할 정복 알고리즘")
    public int[] mergeSort(int[] numberArray) {
        int[] array = numberArray.clone();
        int[] cloneArray = new int[array.length];
        mergeSortDivideLogic(array, cloneArray, 0, array.length - 1);
        return array;
    }

    /**
     *
     * @param numberArray 정렬이 필요한 배열
     * @param cloneArray 정렬을 위한 배열 복사본
     * @param start 시작점
     * @param end 끝점
     */
    private void mergeSortDivideLogic(int[] numberArray, int[] cloneArray, int start, int end) {
        // 크기가 1보다 큰 경우
        if (start < end) {
            int middle = (start + end) / 2;

            // 배열을 왼쪽, 오른쪽으로 나눈다.
            mergeSortDivideLogic(numberArray, cloneArray, start, middle);
            mergeSortDivideLogic(numberArray, cloneArray, middle + 1, end);

            // 정렬된 두 개의 배열을 합쳐준다.
            mergeSortMergeLogic(numberArray, cloneArray, start, middle, end);
        }
    }


    /**
     * @param numberArray 정렬이 필요한 배열
     * @param cloneArray 정렬을 위한 예비 배열
     * @param leftStart: 첫번째 배열의 시작점
     * @param leftEnd: 첫번째 배열의 끝점 (leftEnd + 1: 두번째 배열의 시작점)
     * @param rightEnd: 두번째 배열의 끝점
     * @return
     */
    private void mergeSortMergeLogic(int[] numberArray, int[] cloneArray, int leftStart, int leftEnd, int rightEnd) {
        int i = leftStart;
        int j = leftEnd + 1;
        int k = leftStart;

        // 작은 순서대로 배열에 삽입
        while (i <= leftEnd && j <= rightEnd) {
            if (numberArray[i] <= numberArray[j]) {
                cloneArray[k++] = numberArray[i++];
            } else {
                cloneArray[k++] = numberArray[j++];
            }
        }

        // 이 경우, i 값이 남거나 j 값이 남거나 둘 중 하나의 값이 남게된다.
        // 남은 데이터 삽입
        if (i > leftEnd) {
            for (int t = j; t <= rightEnd; t++) {
                cloneArray[k++] = numberArray[t];
            }
        } else {
            for (int t = i; t <= leftEnd; t++) {
                cloneArray[k++] = numberArray[t];
            }
        }

        // 정렬된 배열을 삽입
        for (int t = leftStart; t <= rightEnd; t++) {
            numberArray[t] = cloneArray[t];
        }
    }

    @BigONotation(
            bestBigO = "O(N * logN)",
            averageBigO = "O(N * logN)",
            worstBigO = "O(N^2)",
            description =
                    "퀵 정렬 - 분할 정복 알고리즘, 평균적으로 가장 빠른 정렬 알고리즘" +
                    "다만, 이미 정렬이 되어있거나 같은 수만으로 이루어져 있을경우 정렬 속도가 느리다."
    )
    public int[] quickSort(int[] numberArray) {
        int[] array = numberArray.clone();
//        quickSortWithRecursive(array, 0, numberArray.length - 1);
        quickSortWithQueue(array, 0, numberArray.length - 1);
        return array;
    }

    // 재귀 Quick Sort
    private void quickSortWithRecursive(int[] numberArray, int low, int high) {
        if (low >= high) return;

        int mid = partition(numberArray, low, high);
        quickSortWithRecursive(numberArray, low, mid - 1);
        quickSortWithRecursive(numberArray, mid, high);
    }

    private int partition(int[] numberArray, int low, int high) {
        int pivot = numberArray[(low + high) / 2];
        do {
            while (numberArray[low] < pivot) low++;
            while (numberArray[high] > pivot) high--;
            if (low <= high) {
                swap(numberArray, low++, high--);
            }
        } while (low <= high);
        return low;
    }

    private void swap(int[] numberArray, int i, int j) {
        int temp = numberArray[i];
        numberArray[i] = numberArray[j];
        numberArray[j] = temp;
    }

    // 비재귀 Quick Sort
    public void quickSortWithQueue(int[] array, int low, int high) {
        Stack<Integer> lowStack = new Stack<>();
        Stack<Integer> highStack = new Stack<>();

        lowStack.push(low);
        highStack.push(high);

        while(!lowStack.isEmpty()) {
            int lowCursor = low = lowStack.pop();
            int highCursor = high = highStack.pop();
            int pivot = array[(low + high) / 2];

            do {
                while (array[low] < pivot) low++;
                while (array[high] > pivot) high--;

                if (low <= high) {
                    swap(array, low++, high--);
                }

            } while (low <= high);

            if (low < highCursor) {
                lowStack.push(low);
                highStack.push(highCursor);
            }
            if (lowCursor < high) {
                lowStack.push(lowCursor);
                highStack.push(high);
            }
        }
    }

    // 계속해서 List를 생성하기 때문에 비효율적이다.
    public List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        int pivot = list.get(list.size() / 2);

        List<Integer> lesserList = new ArrayList<>();
        List<Integer> equalList = new ArrayList<>();
        List<Integer> greaterList = new ArrayList<>();

        for (Integer index : list) {
            if (list.get(index) < pivot) lesserList.add(list.get(index));
            else if (list.get(index) == pivot) equalList.add(list.get(index));
            else greaterList.add(list.get(index));
        }

        return Stream.of(
                quickSort(lesserList),
                equalList,
                quickSort(greaterList)
        ).flatMap(Collection::stream)
        .collect(Collectors.toList());
    }

    /*
    각 숫자를 적절한 위치에 삽입하는 방법으로, 필요할 때만 위치를 변경한다.
    특정한 원소에서 앞의 원소의 적당한 위치로 들어가면서 위치를 변경한다.
    특정 원소의 위치를 지정할때, 앞의 원소는 이미 정렬되어 있는 상태이므로 또다시 정렬할 필요 없이 특정 원소의 위치만 지정해주면 된다.

    1, 10, 5, 8, 7, 12, 6, 11, 4, 3, 2, 9
    1, 5, 10, 8, 7, 12, 6, 11, 4, 3, 2, 9
    1, 5, 8, 10, 7, 12, 6, 11, 4, 3, 2, 9
    1, 5, 8, 7, 10, 12, 6, 11, 4, 3, 2, 9
    1, 5, 7, 8, 10, 12, 6, 11, 4, 3, 2, 9
    1, 5, 7, 8, 10, 6, 12, 11, 4, 3, 2, 9
    1, 5, 7, 8, 6, 10, 12, 11, 4, 3, 2, 9
    1, 5, 7, 6, 8, 10, 12, 11, 4, 3, 2, 9
    1, 5, 6, 7, 8, 10, 12, 11, 4, 3, 2, 9
    1, 5, 6, 7, 8, 10, 11, 12, 4, 3, 2, 9
    1, 5, 6, 7, 8, 10, 11, 4, 12, 3, 2, 9
    1, 5, 6, 7, 8, 10, 4, 11, 12, 3, 2, 9
    1, 5, 6, 7, 8, 4, 10, 11, 12, 3, 2, 9
    1, 5, 6, 7, 4, 8, 10, 11, 12, 3, 2, 9
    1, 5, 6, 4, 7, 8, 10, 11, 12, 3, 2, 9
    1, 5, 4, 6, 7, 8, 10, 11, 12, 3, 2, 9
    1, 4, 5, 6, 7, 8, 10, 11, 12, 3, 2, 9
    ...

    삽입 정렬의 시간 복잡도는 O(N^2)
    시간 복잡도는 선택 정렬 및 버블 정렬과 동일하지만, 연산의 수행이 적기 때문에 2개의 정렬보다는 더 빠르다.
    특히, 이미 거의 정렬된 경우에는 다른 시간 복잡도가 더 효율적인 정렬 알고리즘보다 빠르다..
    */
    @BigONotation(
            bestBigO = "O(N^2)",
            averageBigO = "O(N^2)",
            worstBigO = "O(N^2)",
            description =
                    "삽입 정렬, 연산의 수행이 적어 버블 정렬이나 선택 정렬보다 빠르다." +
                    "또한, 정렬이 거의 되어 있는 집합의 경우 다른 효율적인 정렬 알고리즘보다 빠르다."
    )
    public int[] insertionSort(int[] numberArray) {
        int[] array = numberArray.clone();

        for (int index = 0; index < array.length - 1; index++) {
            int innerIndex = index;

            // 이전 원소가 선택된 원소보다 큰 경우에만 옮긴다.
            while (array[innerIndex] > array[innerIndex + 1]) {
                int temp = array[innerIndex];
                array[innerIndex] = array[innerIndex + 1];
                array[innerIndex + 1] = temp;

                if (innerIndex != 0) {
                    innerIndex--;
                } else {
                    break;
                }
            }
        }

        return array;
    }

    /*
    버블 정렬: 옆의 값과 비교하여, 큰 값을 오른쪽으로 보내는 방법.

    한 번의 반복이 끝났을때, 가장 큰 값이 가장 오른쪽에 위치하게 된다.
    이것을 계속 반복한다.

    버블 정렬의 시간 복잡도는 O(N^2)
    수행 시간: N * (N + 1) / 2 => N * N => O(N*N)

    시간 복잡도는 선택 정렬과 동일하지만, 비교를 할 때마다 값을 변경해줘야 한다는 단점이 있어서 버블 정렬이 더 느리다.
     */
    @BigONotation(
            bestBigO = "O(N^2)",
            averageBigO = "O(N^2)",
            worstBigO = "O(N^2)",
            description = "버블 정렬. 느리지만 구현이 쉽다."
    )
    public int[] bubbleSort(int[] numberArray) {
        int[] array = numberArray.clone();
        for (int index = 0; index < array.length; index++) {
            for (int innerIndex = 0; innerIndex < array.length - index - 1; innerIndex++) {
                if (array[innerIndex] > array[innerIndex + 1]) {
                    int temp = array[innerIndex];
                    array[innerIndex] = array[innerIndex + 1];
                    array[innerIndex + 1] = temp;
                }
            }
        }
        return array;
    }

    /*
    선택 정렬: 가장 작은 값을 선택하여, 맨 앞의 값과 바꿔치기 하는 방법
    선택 정렬의 시간 복잡도는 O(N^2)
    수행 시간: N * (N + 1) / 2 => N * N => O(N*N)
     */
    @BigONotation(
            bestBigO = "O(N^2)",
            averageBigO = "O(N^2)",
            worstBigO = "O(N^2)",
            description = "선택 정렬. 느리지만 구현이 쉽다."
    )
    public int[] selectionSort(int[] numberArray) {
        int[] array = numberArray.clone();
        int currentNumberIndex = 0;
        int rowNumber = 0;

        for (int index = 0; index < array.length; index++) {
            currentNumberIndex = index;
            rowNumber = array[index];

            for (int innerIndex = index; innerIndex < array.length; innerIndex++) {
                if (rowNumber > array[innerIndex]) {
                    currentNumberIndex = innerIndex;
                    rowNumber = array[innerIndex];
                }
            }

            int temp = array[index];
            array[index] = rowNumber;
            array[currentNumberIndex] = temp;
        }
        return array;
    }
}
