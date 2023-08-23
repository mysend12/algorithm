package hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        if (participant.length == 1) return participant[0];

        Map<String, Integer> participantMap = new HashMap<>();
        for (String s : participant) {
            int count = participantMap.getOrDefault(s, 0) + 1;
            participantMap.put(s, count);
        }

        for (String s : completion) {
            Integer count = participantMap.get(s);
            if (count == null) {
                return s;
            } if (count == 1) {
                participantMap.remove(s);
            } else{
                participantMap.put(s, count - 1);
            }
        }

        return participantMap.keySet().stream().findFirst().get();
    }
}
