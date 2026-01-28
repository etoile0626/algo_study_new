package Programmers;

/*
    0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 있을때,
    numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 구하기
 */

public class Solution_Pro86051 {                            //없는 숫자 더하기
    class Solution {
        public int solution(int[] numbers) {
            boolean[] check = new boolean[10];
            int answer = 0;

            for(int i = 0; i < numbers.length; i++){
                check[numbers[i]] = true;
            }

            for(int i = 0; i < 10; i++){
                if(!check[i]){
                    answer += i;
                }
            }

            return answer;
        }
    }
}
