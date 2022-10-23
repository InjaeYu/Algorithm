import java.lang.Math;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<Character, Integer> indicator = new HashMap();
    
    public Solution() {
        indicator.put('R', 0);
        indicator.put('T', 0);
        indicator.put('C', 0);
        indicator.put('F', 0);
        indicator.put('J', 0);
        indicator.put('M', 0);
        indicator.put('A', 0);
        indicator.put('N', 0);
    }
    
    public String solution(String[] survey, int[] choices) {
        for(int i = 0; i < choices.length; i++) {
            int value = choices[i] - 4;
            if(value == 0) {
                continue;
            }
            
            Character k = null;
            if(value > 0) {
                // 0보다 큰 경우 : survey의 두 번째 캐릭터
                k = Character.valueOf(survey[i].charAt(1));
            } else {
                // 0보다 작은 경우: survey의 첫 번째 캐릭터
                k = Character.valueOf(survey[i].charAt(0));
            }
            indicator.replace(k, indicator.get(k) + Math.abs(value));
        }
        
        StringBuffer answer = new StringBuffer();
        answer.append(compareCategory('R', 'T'));
        answer.append(compareCategory('C', 'F'));
        answer.append(compareCategory('J', 'M'));
        answer.append(compareCategory('A', 'N'));
        
        return answer.toString();
    }
    
    public char compareCategory(Character k1, Character k2) {
        Integer v = indicator.get(k1) - indicator.get(k2);
        if(v == 0) return k1.compareTo(k2) > 0 ? k2.charValue() : k1.charValue();
        else if(v > 0) return k1.charValue();
        else return k2.charValue();
    }
}