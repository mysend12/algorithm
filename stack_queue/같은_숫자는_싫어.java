package stack_queue;

import java.util.*;

public class 같은_숫자는_싫어 {

    public int[] solution(int[] arr) {
        int prev = -1;
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i != prev) {
                list.add(i);
                prev = i;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
