class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        if(x == 0) {
            return answer;
        }
        for(int i = 0; i < n; i++) {
            long v = (long)x * (i + 1);
            answer[i] = v;
        }
        return answer;
    }
}