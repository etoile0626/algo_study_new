package Programmers;

/*
    피보나치 수 : F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수
    2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 하기
 */

public class Solution_Pro12945 {                            //피보나치 수
    class Solution {
        public int solution(int n) {
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i < n+1; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
            }
            int answer = dp[n];
            return answer;
        }
    }
}
