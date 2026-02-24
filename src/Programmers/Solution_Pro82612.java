package Programmers;

/*
    놀이기구의 원래 이용료는 price원 인데, 놀이기구를 N 번 째 이용한다면 원래 이용료의 N배를 받기로 함.
    ex) 이용료가 100이었다면 2번째에는 200, 3번째에는 300으로 요금이 인상
    놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return하기.
 */

public class Solution_Pro82612 {                            //부족한 금액 계산하기
    class Solution {
        public long solution(int price, int money, int count) {
            long answer = -1;
            long[] dp = new long[count+1];
            dp[1] = price;

            for(int i = 2; i <= count; i++){
                dp[i] = dp[i-1] + price * i;
            }

            if(dp[count] - money > 0){
                answer = dp[count] - money;
            } else{
                answer = 0;
            }

            return answer;
        }
    }
}
