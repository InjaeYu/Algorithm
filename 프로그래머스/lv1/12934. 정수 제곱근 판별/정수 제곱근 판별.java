class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        boolean b = String.valueOf(sqrt).split("\\.")[1].equals("0");
        if(b) {
            return (long)Math.pow(sqrt + 1, 2);
        } else {
            return -1;
        }
    }
}