package io.my.programmers;

import java.util.Stack;

public class Solution12906 {

    public static void main(String[] args) {

        Solution12906 solution = new Solution12906();
        int[] solution1 = solution.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        for (int i : solution1) {
            System.out.println(i);
        }
    }


    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        if (arr.length < 2) return arr;

        stack.add(arr[0]);
        for (int index=1; index < arr.length; index++) {
            if (arr[index] != stack.peek()) {
                stack.add(arr[index]);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
