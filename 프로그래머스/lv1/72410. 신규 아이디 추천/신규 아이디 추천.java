class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase()
        .replaceAll("[^a-z0-9\\-_\\.]", "")
        .replaceAll("\\.{2,}", ".")
        .replaceAll("^\\.|\\.$", "");
    
        if(answer.length() == 0) {
            answer = "a";
        }
        
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15).replaceAll("\\.$", "");
        }

        int len = answer.length();
        if(len < 3) {
            answer = answer.concat(
                String.valueOf(
                    answer.charAt(len - 1))
                .repeat(3 - len));
        }

        return answer;
    }
}