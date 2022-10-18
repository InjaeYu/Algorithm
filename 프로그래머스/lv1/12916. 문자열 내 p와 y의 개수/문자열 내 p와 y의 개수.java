class Solution {
    boolean solution(String s) {
        String lowerString = s.toLowerCase();
        int pCount = lowerString.replaceAll("[^p]*", "").length();
        int yCount = lowerString.replaceAll("[^y]*", "").length();
        return pCount == yCount;
    }
}