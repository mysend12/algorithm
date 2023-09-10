package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더_맵게 {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = Arrays.stream(scoville)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int index = 0;
        int min = queue.peek();
        while (K > min && queue.size() > 1) {
            index++;
            int a = queue.poll();
            int b = queue.poll();
            int temp = a + (b * 2);
            queue.add(temp);
            min = queue.peek();
        }

        return K > min ? -1 : index;
    }
}
