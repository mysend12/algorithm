package hash;

import java.util.HashSet;
import java.util.Set;

public class Phonecatmon {

    public int solution(int[] nums) {
        int half = nums.length / 2;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        return Math.min(set.size(), half);
    }

}
