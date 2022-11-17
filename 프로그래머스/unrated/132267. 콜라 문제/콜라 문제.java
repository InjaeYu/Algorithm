class Solution {
    public int solution(int give, int take, int have) {
        int answer = 0;
        while(true) {
            int exchange = (have / give) * take;
            answer += exchange;
            have = exchange + (have % give);
            if(have < give) {
                break;
            }
        }
        return answer;
    }
}