class Solution {
    public long solution(long w, long h) {
        long ret =  (w * h) - (w + h - gcd(w, h));
        return ret > 0 ? ret : 0;
    }
    
    private static long gcd(long a, long b) {
        if(a < 0 || b < 0) return 0;
        
        if(b > a) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        
        if(a % b != 0)
            return gcd(b, a % b);
        else
            return b;
    }
}