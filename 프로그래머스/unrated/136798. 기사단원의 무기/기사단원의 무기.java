class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int numberPower = getDivisorCount(i);
            if(numberPower > limit) {
                numberPower = power;
            }
            answer += numberPower;
        }
        return answer;
    }
    
    private int getDivisorCount(int num) {
        if(num == 1) {
            return 1;
        }
        
        int count = 2;
        double sqrt = Math.sqrt(num);
        
        for(int i = 2; i <= sqrt; i++) {
            if(num % i == 0) {
                if(i == sqrt) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        
        return count;
    }
}