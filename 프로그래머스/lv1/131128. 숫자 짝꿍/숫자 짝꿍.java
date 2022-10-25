import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String X, String Y) {
        Map<Character, Integer> xMap = new HashMap<>();
        Map<Character, Integer> yMap = new HashMap<>();
        
        for(char c : X.toCharArray()) {
            Character key = Character.valueOf(c);
            if(xMap.containsKey(key)) {
                xMap.replace(key, xMap.get(key) + 1);
            } else {
                xMap.put(key, 1);
            }
        }
        
        for(char c : Y.toCharArray()) {
            Character key = Character.valueOf(c);
            if(yMap.containsKey(key)) {
                yMap.replace(key, yMap.get(key) + 1);
            } else {
                yMap.put(key, 1);
            }
        }
        
        StringBuffer answer = new StringBuffer();
        List<Character> keyList = new ArrayList<>(xMap.keySet());
        keyList.sort((k1, k2) -> k2.compareTo(k1));
        
        for(Character k : keyList) {
            if(yMap.containsKey(k)) {
                int count = 0;
                if(xMap.get(k) >= yMap.get(k)) {
                    count = yMap.get(k);
                } else {
                    count = xMap.get(k);
                }

                for(int i = 0; i < count; i++) {
                    answer.append(k);
                }
            }
        }
        
        if(answer.length() == 0) {
            return "-1";
        } else {
            return answer.toString().replaceAll("0", "").length() == 0 ? "0" : answer.toString();
        }
    }
}