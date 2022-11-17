import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] food) {
        return getFoodList(food);
    }
    
    private String getFoodList(int[] foods) {
        List<Integer> foodList = new ArrayList<>();
        for(int i = 1; i < foods.length; i++) {
            foodList.addAll(calcFood(i, foods[i]));
        }
        List<Integer> tempList = foodList.stream().sorted((l, r) -> r - l).collect(Collectors.toList());
        foodList.add(0);
        foodList.addAll(tempList);
        
        return foodList.stream().map(String::valueOf).collect(Collectors.joining());
    }
    
    private List<Integer> calcFood(int calorie, int count) {
        int loopCount = count / 2;
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < loopCount; i++) {
            result.add(calorie);
        }
        
        return result;
    }
}