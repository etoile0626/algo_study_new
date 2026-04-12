package Programmers;

public class Solution_Pro12931 {                                //자릿수 더하기
    public class Solution {
        public int solution(int n) {
            int answer = 0;

            while(n > 0){
                answer += n % 10;
                n = n / 10;
            }

            return answer;
        }
    }
}
