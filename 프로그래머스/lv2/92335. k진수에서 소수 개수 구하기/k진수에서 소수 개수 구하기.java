class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String convertNum = Integer.toString(n, k);
        
        for(String s : convertNum.split("0", -1)) {
            if(s.length() == 0) continue;
            
            if(isPrimeNumber(Double.parseDouble(s))) {
                answer += 1;
            }
        }
        return answer;
    }
    
    private boolean isPrimeNumber(double n) {
        if(n <= 1) return false;
        
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}