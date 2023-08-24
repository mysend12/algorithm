package hash;

import java.util.HashSet;
import java.util.Set;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        Set<String>[] setArray = new HashSet[20];
        for (int i=0; i<20; i++) {
            setArray[i] = new HashSet<>();
        }

        for (String phone : phone_book) {
            setArray[phone.length() - 1].add(phone);
        }

        for (int index = setArray.length - 1; index >= 1; index--) {
            for (String phone : setArray[index]) {
                for (int jIndex = 0; jIndex < index; jIndex++) {
                    String word = phone.substring(0, jIndex + 1);
                    if (setArray[jIndex].contains(word)) return false;
                }
            }
        }
        return true;
    }
}
