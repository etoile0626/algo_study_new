package Programmers;

/*
    효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
    멀리뛰기에 사용될 칸의 수 n이 주어질 때,
    효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
    여기에 1234567를 나눈 나머지를 리턴하기.
 */

public class Solution_Pro12914 {                            //멀리 뛰기
    class Solution {
        public long solution(int n) {
            long[] dp = new long[n+1];

            dp[0] = 0;
            dp[1] = 1;

            if(n > 1){
                dp[2] = 2;

                if(n > 2){
                    for(int i = 3; i <= n; i++){
                        dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
                    }
                }
            }

            return dp[n];
        }
    }
}
