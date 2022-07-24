import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int nodeCount = Integer.parseInt(br.readLine()) - 1;
        Map<Integer, List<Integer>> map = new HashMap<>(nodeCount);
        int[] pNodes = new int[nodeCount];

        // input
        while(nodeCount-- > 0) {
            int[] inputIntegerArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .sorted()
                    .toArray();
            int a = inputIntegerArr[0], b = inputIntegerArr[1];
            addMap(map, a, b);
            addMap(map, b, a);
        }

        // logic
        calcKey(map, pNodes, 1);

        // output
        Iterator<Integer> it = Arrays.stream(pNodes).iterator();
        while(it.hasNext()) {
            sb.append(it.next().toString());
            if(it.hasNext())
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void addMap(Map<Integer, List<Integer>> map, int key, int value) {
        if(map.containsKey(key))
            map.get(key).add(value);
        else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    private static void calcKey(Map<Integer, List<Integer>> map, int[] pNodes, int key) {
        for(Integer i : map.get(key)) {
            if(i == 1 || pNodes[i - 2] > 0) continue;
            pNodes[i - 2] = key;
            calcKey(map, pNodes, i);
        }
    }
}