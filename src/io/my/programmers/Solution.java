package io.my.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int index = 0; index < commands.length; index++) {
            answer[index] = solution(array, commands[index]);
        }

        return answer;
    }

    public int solution(int[] array, int[] command) {
        int length = command[1] - command[0] + 1;

        int[] sortArray = new int[length];

        int sortArrayIndex = 0;

        for (int index = command[0] - 1; index < command[1]; index++) {
            sortArray[sortArrayIndex++] = array[index];
        }

        sortArray = quickSort(sortArray);

        return sortArray[command[2] - 1];
    }

    public int[] quickSort(int[] array) {
        int low = 0;
        int high = array.length - 1;

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
        return array;
    }
    private void swap(int[] numberArray, int i, int j) {
        int temp = numberArray[i];
        numberArray[i] = numberArray[j];
        numberArray[j] = temp;
    }
}
