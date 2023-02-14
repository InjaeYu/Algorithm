import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder ret = new StringBuilder();
            List<Integer> skipList = skip.chars().boxed().collect(Collectors.toList());
            for (char c : s.toCharArray()) {
                int i = 1;
                while (i <= index) {
                    c += 1;
                    if(c > 'z') {
                        c -= ('z' - 'a') + 1;
                    }
                    if(skipList.contains((int)c)) {
                        continue;
                    }
                    i += 1;
                }
                ret.append(Character.toChars(c));
            }
    
            return ret.toString();
    }
}