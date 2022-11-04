import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int min = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).min().orElse(0);
        int max = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).max().orElse(0);
        String answer = min + " " + max;
        return answer;
    }
}