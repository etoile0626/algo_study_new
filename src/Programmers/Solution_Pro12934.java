package Programmers;

public class Solution_Pro12934 {                            //정수 제곱근 판별
    class Solution {
        public long solution(long n) {
            long answer = -1;
            long num = (long)Math.sqrt(n);

            if(num * num == n){
                answer = (num + 1) * (num + 1);
            }

            return answer;
        }
    }
}
