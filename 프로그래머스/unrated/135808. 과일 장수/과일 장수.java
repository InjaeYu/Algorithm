import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        for(List<Integer> appleBox : packagingApple(m, score)) {
            answer += sellApple(k, appleBox);
        }
        return answer;
    }
    
    private List<List<Integer>> packagingApple(int m, int[] apples) {
        List<Integer> appleList = Arrays.stream(apples).boxed().sorted((l, r) -> r - l).collect(Collectors.toList());
        List<List<Integer>> appleBoxs = new ArrayList<>();
        
        for(int i = 0; i + m <= appleList.size(); i += m) {
            appleBoxs.add(appleList.subList(i, i + m));
        }
        
        return appleBoxs;
    }
    
    private int sellApple(int max, List<Integer> appleBox) {
        int min = appleBox.stream().mapToInt(i -> i).min().orElse(0);
        if(min > max) {
            min = max;
        }
        
        return min * appleBox.size();
    }
}