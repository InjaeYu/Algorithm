class Solution {
    public int solution(String s) {
        if(s.length() < 3) {
            return 1;
        }
        
        int answer = 1, baseCount = 1, diffCount = 0;
        char[] stringArray = s.toCharArray();
        char base = stringArray[0];
        for(int i = 1; i < stringArray.length; i++) {
            if(stringArray[i] == base) {
                baseCount += 1;
            } else {
                diffCount += 1;
            }
            
            if(baseCount == diffCount) {
                baseCount = 1;
                diffCount = 0;
                if(i + 1 < stringArray.length) {
                    base = stringArray[++i];
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
}