import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 7 - (int)Arrays.stream(win_nums)
            .filter(i -> Arrays.stream(lottos)
                   .anyMatch(j -> i == j))
            .count();
        int max = min - (int)Arrays.stream(lottos)
            .filter(i -> i == 0)
            .count();
        if(min == 7) min = 6;
        if(max == 7) max = 6;
        return new int[]{max, min};
    }
}