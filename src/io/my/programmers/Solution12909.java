package io.my.programmers;

public class Solution12909 {
    public static void main(String[] args) {
        Solution12909 solution = new Solution12909();
        System.out.println(solution.solution(")()("));
    }

    boolean solution(String s) {
        int leftDoor = 0;

        for (int index=0; index<s.length(); index++){
            if (s.charAt(index) == '(') {
                leftDoor++;
            } else if (s.charAt(index) == ')') {
                leftDoor--;
            }

            if (leftDoor < 0) return false;
        }

        if (leftDoor == 0) return true;
        return false;
    }
}
