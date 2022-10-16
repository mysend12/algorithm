package io.my.programmers;

public class Solution84512 {

    // https://bcp0109.tistory.com/14
    public static void main(String[] args) {
        Solution84512 solution = new Solution84512();
        System.out.println(solution.solution("EIO"));;
    }

    public int solution(String word) {
        char[] charArray = {'A', 'E', 'I', 'O', 'U'};

        StringBuilder stringBuilder = new StringBuilder();

        int answer = 0;
        for (int a = 0; a < charArray.length; a++) {
            stringBuilder.append(charArray[a]);
            answer++;
            if (word.equals(stringBuilder.toString())) {
                return answer;
            }
            for (int b = 0; b < charArray.length; b++) {
                stringBuilder.append(charArray[b]);
                answer++;
                if (word.equals(stringBuilder.toString())) {
                    return answer;
                }
                for (int c = 0; c < charArray.length; c++) {
                    stringBuilder.append(charArray[c]);
                    answer++;
                    if (word.equals(stringBuilder.toString())) {
                        return answer;
                    }
                    for (int d = 0; d < charArray.length; d++) {
                        stringBuilder.append(charArray[d]);
                        answer++;
                        if (word.equals(stringBuilder.toString())) {
                            return answer;
                        }
                        for (int e = 0; e < charArray.length; e++) {
                            stringBuilder.append(charArray[e]);
                            answer++;
                            if (word.equals(stringBuilder.toString())) {
                                return answer;
                            }
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return answer;
    }

}
