package stack_queue;

import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] seconds = new int[prices.length];
        Stack<Integer> indexStack = new Stack<>();

        indexStack.push(0);
        for (int i = 1; i < prices.length; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] > prices[i]) {
                int popIndex = indexStack.pop();
                seconds[popIndex] = i - popIndex;
            }
            indexStack.push(i);
        }

        for (int i = 0; i < seconds.length; i++) {
            if (seconds[i] == 0) {
                seconds[i] = seconds.length - i - 1;
            }
        }

//        List<Integer>[] arrays = new ArrayList[10001];
//
//        for (int i = 0; i < prices.length; i++) {
//            if (arrays[prices[i]] == null) {
//                arrays[prices[i]] = new ArrayList<>();
//            }
//            List<Integer> priceIndexes = arrays[prices[i]];
//
//            for (int j = prices[i] + 1; j < arrays.length; j++) {
//                if (arrays[j] == null) continue;
//                for (Integer second : arrays[j]) {
//                    seconds[second] = i - second;
//                }
//                arrays[j].clear();
//            }
//            priceIndexes.add(i);
//        }
//
//        for (int i = 0; i < seconds.length; i++) {
//            if (seconds[i] == 0) seconds[i] = prices.length - 1 - i;
//        }

        return seconds;
    }
}
