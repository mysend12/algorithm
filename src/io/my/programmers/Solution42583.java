package io.my.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution42583 {

    public static void main(String[] args) {
        Solution42583 solution = new Solution42583();
        System.out.println(
                solution.solution(
                        2, 10, new int[]{7,4,5,6}
//                        100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
                )
        );

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        if (truck_weights.length == 1) {
            return bridge_length + 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(bridge_length + 1);

        int totalWeight = truck_weights[0];
        int upIndex = 1;
        int downIndex = 0;

        int progressTime = 1;
        while (upIndex != truck_weights.length) {
            progressTime++;
            if (queue.peek() == progressTime) {
                queue.poll();
                totalWeight -= truck_weights[downIndex++];
            }

            if (weight >= totalWeight + truck_weights[upIndex]) {
                queue.add(progressTime + bridge_length);
                totalWeight += truck_weights[upIndex++];
            }
        }

        int downTime = 0;
        while (!queue.isEmpty()) {
            downTime = queue.poll();
        }

        return downTime;
    }
}
