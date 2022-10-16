package io.my.programmers;

import java.util.HashSet;
import java.util.Set;

public class Solution12981 {

    public static void main(String[] args) {
        Solution12981 solution = new Solution12981();

        int[] result = solution.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});

        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] solution(int n, String[] words) {
        int people = 1;
        int count = 1;

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for (int i=1; i<words.length; i++) {
            if (
                    set.contains(words[i]) ||
                    words[i].charAt(0) != words[i-1].charAt(words[i-1].length() - 1)
            ) {
                return new int[]{people + 1, count};
            }
            set.add(words[i]);
            if (++people == n) {
                people = 0;
                count++;
            }
        }

        return new int[]{0, 0};
    }
}
