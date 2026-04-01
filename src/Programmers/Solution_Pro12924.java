package Programmers;

/*
    자연수 n이 매개변수로 주어질 때, 연속된 자연수들로 n을 표현하는 방법의 수를 구하기.
    ex) n = 15라면
    1 + 2 + 3 + 4 + 5 = 15
    4 + 5 + 6 = 15
    7 + 8 = 15
    15 = 15
    로 총 4가지 존재.
 */

public class Solution_Pro12924 {                                        //숫자의 표현
    //다시 풀기
    class Solution {
        public int solution(int n) {
            int answer = 0;

            for(int i = 1; i <= n; i++){
                int sum = 0;

                for(int j = i; j <= n; j++){
                    sum += j;

                    if(sum >= n){
                        if(sum == n) answer++;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
