import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    static String[] words = new String[]{"aya", "ye", "woo", "ma"};
    String ImportPattern = ImportWordPattern();
    String duplicatePattern = duplicateWordPattern();

    public int solution(String[] babbling) {
        List<String> babblingList = Arrays.stream(babbling).collect(Collectors.toList());

        babblingList = checkImportWords(babblingList);
        removeDuplicateWords(babblingList);

        return babblingList.size();
    }

    private String ImportWordPattern() {
        StringBuilder sb = new StringBuilder().append("(");
        for(String word : words) {
            sb.append(word).append("|");
        }
        sb.append(")+");
        return sb.toString();
    }

    private String duplicateWordPattern() {
        StringBuilder sb = new StringBuilder().append(".*(");
        for(String word : words) {
            sb.append("(").append(word).append("){2,}|");
        }
        return sb.deleteCharAt(sb.length() - 1).append(").*").toString();
    }

    private List<String> checkImportWords(List<String> babblingList) {
        return babblingList.stream().filter(s -> s.matches(ImportPattern)).collect(Collectors.toList());
    }

    private void removeDuplicateWords(List<String> babblingList) {
        babblingList.removeIf(s -> s.matches(duplicatePattern));
    }
}