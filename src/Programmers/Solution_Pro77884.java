package Programmers;

/*
    두 정수 a부터 b까지의 모든 수들 중 약수의 개수가 짝수면 더하고, 약수의 개수가 홀수면 뺀 수를 구하기.
 */

public class Solution_Pro77884 {                                            //약수의 개수와 덧셈
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for(int i = left; i <= right; i++){
                int num = 0;

                for(int j = 1; j <= i; j++){
                    if(i % j == 0){
                        num++;
                    }
                }

                if(num % 2 == 0){
                    answer += i;
                } else{
                    answer -= i;
                }
            }

            return answer;
        }
    }
}
