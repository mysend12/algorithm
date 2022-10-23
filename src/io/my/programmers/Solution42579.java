package io.my.programmers;

import java.util.*;

public class Solution42579 {
    public static void main(String[] args) {
        Solution42579 solution = new Solution42579();

        System.out.println(
                solution.solution(
                        new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500}
                )
        );

    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Integer>> map = new HashMap<>();

        HashMap<String, Integer> totalMap = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            int totalCount = totalMap.getOrDefault(genres[i], 0);
            totalMap.put(genres[i], totalCount + plays[i]);

            List<Integer> list = map.getOrDefault(genres[i], new ArrayList<>());
            list.add(plays[i]);
        }

        List<String> countGenresList = totalMap.keySet().stream().toList();
        countGenresList.sort(Comparator.comparingInt(totalMap::get));

        System.out.println(countGenresList);

        int[] answer = {};
        return answer;
    }

}
