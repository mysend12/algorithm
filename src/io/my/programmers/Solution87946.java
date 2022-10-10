package io.my.programmers;

import java.util.Stack;

public class Solution87946 {

    int answer = 0;
    // https://bcp0109.tistory.com/14
    public static void main(String[] args) {
        Solution87946 solution = new Solution87946();



    }
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        permutation(dungeons, visited, 0, k);
        return answer;
    }

    private void permutation(int[][] dungeons, boolean[] visited, int depth, int k) {
        for (int i=0; i<dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                permutation(dungeons, visited, depth + 1, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        answer = Math.max(answer, depth);
    }
}
