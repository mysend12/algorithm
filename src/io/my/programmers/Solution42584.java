package io.my.programmers;

import java.util.Stack;

public class Solution42584 {

    public static void main(String[] args) {
        Solution42584 solution = new Solution42584();

        int[] result = solution.solution(new int[]{1, 2, 3, 2, 3});
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int[] answer = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty()) {
                int peek = stack.peek();
                if (prices[peek] > prices[i]) {
                    answer[peek] = i - peek;
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int pop = stack.pop();
            answer[pop] = prices.length - 1 - pop;
        }
        return answer;
    }
}
