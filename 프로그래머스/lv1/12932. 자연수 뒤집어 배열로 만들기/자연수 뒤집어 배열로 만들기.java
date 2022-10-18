class Solution {
    public int[] solution(long n) {
        int i = 0;
        int[] answer = new int[String.valueOf(n).length()];
        while(n > 0) {
            answer[i++] = (int) (n % 10);
            n /= 10;
        }
        return answer;
    }
}