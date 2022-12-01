import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int key : tangerine) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        values.sort((l, r) -> r.compareTo(l));
        
        for(int value : values) {
            if(k <= 0) {
                break;
            }
            k -= value;
            answer += 1;
        }
        
        return answer;
    }
}