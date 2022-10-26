
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<Integer, Integer[]> map = new HashMap<>();
    
    public Solution() {
        map.put(1, new Integer[]{1, 1});
        map.put(2, new Integer[]{1, 2});
        map.put(3, new Integer[]{1, 3});
        map.put(4, new Integer[]{2, 1});
        map.put(5, new Integer[]{2, 2});
        map.put(6, new Integer[]{2, 3});
        map.put(7, new Integer[]{3, 1});
        map.put(8, new Integer[]{3, 2});
        map.put(9, new Integer[]{3, 3});
        map.put(11, new Integer[]{4, 1});   // *
        map.put(0, new Integer[]{4, 2});
        map.put(12, new Integer[]{4, 3});   // #
    }
    
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        Integer left = 11, right = 12;
        int[] leftArr = new int[]{1, 4, 7};
        int[] rightArr = new int[]{3, 6, 9};
        
        for(int i : numbers) {
            if(Arrays.stream(leftArr).anyMatch(o -> o == i)) {
                left = i;
                answer.append("L");
            } else if(Arrays.stream(rightArr).anyMatch(o -> o == i)) {
                right = i;
                answer.append("R");
            } else {
                int leftDistance = distanceCalc(left, i);
                int rightDistance = distanceCalc(right, i);
                System.out.print("Left : " + leftDistance + ", Right : " + rightDistance);
                if(leftDistance == rightDistance) {
                    char c;
                    if(hand.equals("left")) {
                        c = 'L';
                        left = i;
                    } else {
                        c = 'R';
                        right = i;
                    }
                    answer.append(c);
                    // System.out.println("\t | add : " + c);
                } else if(leftDistance < rightDistance) {
                    answer.append("L");
                    left = i;
                    // System.out.println("\t | add : L");
                } else {
                    answer.append("R");
                    right = i;
                    // System.out.println("\t | add : R");
                }
            }
        }
        
        return answer.toString();
    }
    
    private int distanceCalc(int i, int j) {
        int row = map.get(i)[0] - map.get(j)[0];
        int col = map.get(i)[1] - map.get(j)[1];
        return Math.abs(row) + Math.abs(col);
    }
}