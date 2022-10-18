class Solution {
    public int solution(String s) {
        return Integer.parseInt(s);
        // char c = s.charAt(0);
        // if(c == '-' || c == '+') {
        //     int num = Integer.parseInt(s.substring(1, s.length()));
        //     return c == '+' ? num : -num;
        // } else {
        //     return Integer.parseInt(s);
        // }
    }
}