package io.my.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution42577 {
    public static void main(String[] args) {
        Solution42577 solution = new Solution42577();

        System.out.println(solution.solution(new String[]{"12","123","1235","567","88"}));
    }

    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        StringBuilder stringBuilder = new StringBuilder();
        for (String phone : phone_book) {
            for (int index=0; index<phone.length() - 1; index++) {
                stringBuilder.append(phone.charAt(index));
                if (set.contains(stringBuilder.toString())) return false;
            }
            stringBuilder.delete(0, stringBuilder.length());
        }

        return true;
    }

//    public boolean solution(String[] phone_book) {
//        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
//
//        int maxSize = phone_book[phone_book.length - 1].length();
//
//        for (int i=0; i<phone_book.length - 1; i++) {
//            if (maxSize == phone_book[i].length()) return true;
//
//            for (int j=i+1; j<phone_book.length; j++) {
//                if (phone_book[i].length() != phone_book[j].length()) {
//                    if (phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
