import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int count = 1, passCount = 0;
        List<Integer> resultList = new ArrayList<>();
        Queue<Integer> progressQueue = Arrays.stream(progresses)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> speedQueue = Arrays.stream(speeds)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        
        while(!progressQueue.isEmpty()) {
            if((progressQueue.peek() + (speedQueue.peek() * count)) >= 100) {
                
                passCount += 1;
                progressQueue.poll();
                speedQueue.poll();
            } else {
                if(passCount > 0)
                    resultList.add(passCount);
                passCount = 0;
                count += 1;
            }
        }
        if(passCount > 0)
            resultList.add(passCount);
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}