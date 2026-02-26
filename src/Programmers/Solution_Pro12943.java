package Programmers;

/*
    주어진 수가 1이 될 때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측이 있다.
    1-1. 입력된 수가 짝수라면 2로 나눕니다.
    1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
    2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
    위 작업을 몇 번이나 반복해야 하는지 반환하는 함수 만들기
 */

public class Solution_Pro12943 {
    class Solution {
        public int solution(int num) {
            int answer = 0;
            long n = num;

            while(n > 1){
                if(n % 2 == 0){
                    n /= 2;
                }else{
                    n = n * 3 + 1;
                }

                answer++;

                if(answer > 500){
                    answer = -1;
                    break;
                }
            }

            return answer;
        }
    }
}
