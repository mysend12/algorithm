package io.my.programmers;

import java.util.*;

public class Solution42578 {
    public static void main(String[] args) {
        Solution42578 solution = new Solution42578();
        System.out.println(solution.solution(
                new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}
        ));
        solution.count = 0;
        System.out.println(
                solution.solution(
                        new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}
                )
        );
    }

    private int count;
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothing : clothes) {
            int count = map.getOrDefault(clothing[1], 0);
            map.put(clothing[1], count + 1);
        }

        Integer[] list = new ArrayList<>(map.values()).toArray(new Integer[0]);

        boolean[] visited = new boolean[list.length];
        int n = list.length;
        for (int i=1; i<=list.length; i++) {
            comb(list, visited, 0, n, i);
        }

        return count;
    }

    private void comb(Integer[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int mul = 1;
            for(int i =0 ; i < visited.length; i++) {
                if(visited[i]) {
                    mul *=arr[i];
                }
            }
            count += mul;
            return;
        }
        for (int i=start; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(arr, visited, i + 1, n, r-1);
                visited[i] = false;;
            }
        }
    }

}
