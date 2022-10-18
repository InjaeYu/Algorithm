class Solution {
    public int solution(String s) {
        char c = s.charAt(0);
        if(c == '-' || c == '+') {
            int num = Integer.parseInt(s.substring(1, s.length()));
            return s.charAt(0) == '+' ? num : -num;
        } else {
            return Integer.parseInt(s);
        }
    }
}