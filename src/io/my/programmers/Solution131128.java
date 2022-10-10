package io.my.programmers;

public class Solution131128 {

    public static void main(String[] args) {
        Solution131128 solution = new Solution131128();
        System.out.println(solution.solution("100", "203045"));
    }

    public String solution(String x, String y) {
        int[] xCountArray = new int[10];
        int[] yCountArray = new int[10];

        for (int index=0; index<x.length(); index++) {
            int idx = x.charAt(index) - '0';
            xCountArray[idx] = xCountArray[idx] + 1;
        }

        for (int index=0; index<y.length(); index++) {
            int idx = y.charAt(index) - '0';
            yCountArray[idx] = yCountArray[idx] + 1;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int index=9; index>=0; index--) {
            int count = Math.min(xCountArray[index], yCountArray[index]);
            xCountArray[index] = count;

            for (int i=0; i<count; i++) {
                stringBuilder.append(index);
            }
        }


        if (stringBuilder.length() == 0) return "-1";
        else if (stringBuilder.charAt(0) == '0') return "0";

        return stringBuilder.toString();
    }
}
