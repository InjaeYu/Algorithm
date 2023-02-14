import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder ret = new StringBuilder();
        for (char c : s.toCharArray()) {
            int i = 1;
            while (i <= index) {
                c += 1;
                if(c > 'z') {
                    c -= ('z' - 'a') + 1;
                }
                if(skip.contains(String.valueOf(c))) {
                    continue;
                }
                i += 1;
            }
            ret.append(Character.toChars(c));
        }

        return ret.toString();
    }
}