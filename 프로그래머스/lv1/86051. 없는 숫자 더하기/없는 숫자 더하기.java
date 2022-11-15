import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int sum = 0;
        for(int i = 0; i < 10; i++) {
            sum += i;
        }
        
        return sum - Arrays.stream(numbers).sum();
    }
}