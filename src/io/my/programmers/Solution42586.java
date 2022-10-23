package io.my.programmers;

import java.util.*;

public class Solution42586 {

    public static void main(String[] args) {
        Solution42586 solution = new Solution42586();
        int[] result = solution.solution(
                new int[]{}, new int[]{}
        );
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] solution(int[] progresses, int[] speeds) {
        int count = progresses.length;

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<count; i++) {
            int rest = 100 - progresses[i];
            int speed = speeds[i];

            int day = 0;
            while (rest > 0) {
                rest -= speed;
                day++;
            }
            queue.add(day);
        }

        int c = 1;

        List<Integer> list = new ArrayList<>();
        int prevDay = queue.poll();

        while (!queue.isEmpty()) {
            int day = queue.poll();
            if (prevDay >= day) {
                c++;
            } else {
                list.add(c);
                c = 1;
                prevDay = day;
            }
        }
        list.add(c);

        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
