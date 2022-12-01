class Solution {
    public long solution(int k, int d) {
        double dd = Math.pow(d, 2);
        long answer = (int)(d / k) + 1;
        
        for(int i = k; i <= d; i += k) {
            double base = dd - Math.pow(i, 2);
            int sqrt = (int)Math.sqrt(base);
            answer += (int)(sqrt / k) + 1;
        }
        
        return answer;
    }
}