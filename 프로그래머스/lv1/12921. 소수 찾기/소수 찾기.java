import java.lang.Math;

class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 3; i <= n; i++) {
            if(isPrimeNumber(i)) {
                answer += 1;
            }
        }
        return answer;
    }
    
    public boolean isPrimeNumber(int n) {
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}