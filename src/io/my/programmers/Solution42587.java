package io.my.programmers;

public class Solution42587 {

    public static void main(String[] args) {
        Solution42587 solution = new Solution42587();
        System.out.println(solution.solution(
                new int[]{1, 1, 2, 3, 2, 1},0
        ));
    }


    public int solution(int[] priorities, int location) {
        int number = priorities[location] + 1;
        int count = 0;
        int lastBiggerIndex = location;

        if (priorities.length == 1) return 1;

        for (int index=location; index < priorities.length; index++) {
            if (priorities[index] >= number) {
                count++;
                if (location == lastBiggerIndex) {
                    lastBiggerIndex = index;
                }

                if (priorities[index] <= priorities[lastBiggerIndex]) {
                    lastBiggerIndex = index;
                }
            }
        }

        for (int index=0; index<location; index++) {
            if (priorities[index] >= number) {
                count++;
                if (location == lastBiggerIndex) {
                    lastBiggerIndex = index;
                }
                if (lastBiggerIndex < location) {
                    if (priorities[index] <= priorities[lastBiggerIndex]) {
                        lastBiggerIndex = index;
                    }
                } else {
                    if (priorities[index] < priorities[lastBiggerIndex]) {
                        lastBiggerIndex = index;
                    }
                }
            }
        }

        if (lastBiggerIndex > location) {
            for (int index=lastBiggerIndex; index < priorities.length; index++) {
                if (priorities[index] == priorities[location]) {
                    count++;
                }
            }
            for (int index=0; index<location; index++) {
                if (priorities[index] == priorities[location]) {
                    count++;
                }
            }
        } else if (lastBiggerIndex < location){
            for (int index=lastBiggerIndex; index<location; index++) {
                if (priorities[index] == priorities[location]) {
                    count++;
                }
            }
        } else {
            for (int index=0; index<location; index++) {
                if (priorities[index] == priorities[location]) {
                    count++;
                }
            }
        }

        return count + 1;
    }
}
