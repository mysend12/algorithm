package hash;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            int count = map.getOrDefault(clothe[1], 0) + 1;
            map.put(clothe[1], count);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }

}
