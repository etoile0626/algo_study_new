package Programmers;

/*
    n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 구하기
    *답이 항상 존재함은 증명될 수 있음.
 */

public class Solution_Pro87389 {                            //나머지가 1이 되는 수 찾기
    class Solution {
        public int solution(int n) {
            int answer = 1;

            while(answer > 0){
                if(n % answer == 1){
                    break;
                }

                answer++;
            }

            return answer;
        }
    }
}
