import java.lang.Math;
import java.util.Arrays;

class Solution {
    /**
    에라스토테네스의 체 방식의 구현
    정확도 테스트
        테스트 1 〉	통과 (0.80ms, 79.3MB)
        테스트 2 〉	통과 (0.87ms, 76.8MB)
        테스트 3 〉	통과 (0.95ms, 79MB)
        테스트 4 〉	통과 (0.99ms, 67.6MB)
        테스트 5 〉	통과 (0.97ms, 75.1MB)
        테스트 6 〉	통과 (1.80ms, 77.6MB)
        테스트 7 〉	통과 (1.43ms, 75.3MB)
        테스트 8 〉	통과 (1.64ms, 76.1MB)
        테스트 9 〉	통과 (1.89ms, 77.4MB)
        테스트 10 〉통과 (13.45ms, 77.3MB)
        테스트 11 〉통과 (22.96ms, 79MB)
        테스트 12 〉통과 (13.85ms, 85.1MB)
    효율성 테스트
        테스트 1 〉	통과 (28.28ms, 55.6MB)
        테스트 2 〉	통과 (68.43ms, 63.4MB)
        테스트 3 〉	통과 (61.96ms, 74.6MB)
        테스트 4 〉	통과 (38.48ms, 55.2MB)
    **/
    public int solution(int n) {
        double sqrt = Math.sqrt(n);
        int[] nArray = new int[n - 1];
        Arrays.fill(nArray, 0);
        
        for(int i = 0; i < sqrt && i < nArray.length; i++) {
            if(nArray[i] == 0) {
                int index = i + 2;
                for(int j = 2; index * j <= nArray.length + 1; j++) {
                    nArray[(index * j) - 2] = 1;
                }
            }
        }
        return (int)Arrays.stream(nArray).filter(i -> i == 0).count();
    }
    
    /**
    3부터 입력 받은 n까지 순회하며 소수인지 판단하는 방식의 구현
    정확성 테스트
        테스트 1 〉	통과 (0.01ms, 79.9MB)
        테스트 2 〉	통과 (0.05ms, 75MB)
        테스트 3 〉	통과 (0.13ms, 76.3MB)
        테스트 4 〉	통과 (0.18ms, 76.2MB)
        테스트 5 〉	통과 (0.12ms, 72MB)
        테스트 6 〉	통과 (1.38ms, 78.3MB)
        테스트 7 〉	통과 (0.45ms, 77MB)
        테스트 8 〉	통과 (1.05ms, 81.7MB)
        테스트 9 〉	통과 (1.10ms, 72.9MB)
        테스트 10 〉통과 (41.90ms, 87.6MB)
        테스트 11 〉통과 (190.70ms, 102MB)
        테스트 12 〉통과 (60.69ms, 77.5MB)
    효율성 테스트
        테스트 1 〉	통과 (205.39ms, 52.5MB)
        테스트 2 〉	통과 (202.02ms, 52.4MB)
        테스트 3 〉	통과 (216.21ms, 52.2MB)
        테스트 4 〉	통과 (186.38ms, 52.1MB)
    **/
//     public int solution(int n) {
//         int answer = 1;
//         for(int i = 3; i <= n; i++) {
//             if(isPrimeNumber(i)) {
//                 answer += 1;
//             }
//         }
//         return answer;
//     }
    
//     public boolean isPrimeNumber(int n) {
//         double sqrt = Math.sqrt(n);
//         for(int i = 2; i <= sqrt; i++) {
//             if(n % i == 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
}