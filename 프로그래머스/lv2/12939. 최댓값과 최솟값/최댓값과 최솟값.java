import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] sArray = s.split(" ");
        // int min = Arrays.stream(sArray).mapToInt(Integer::valueOf).min().orElse(0);
        // int max = Arrays.stream(sArray).mapToInt(Integer::valueOf).max().orElse(0);
        int min = Integer.valueOf(sArray[0]), max = Integer.valueOf(sArray[0]);
        for(String o : sArray) {
            Integer i = Integer.valueOf(o);
            if(min > i) {
                min = i;
            } 
            if(max < i) {
                max = i;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}