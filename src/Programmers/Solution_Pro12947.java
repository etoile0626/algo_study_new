package Programmers;

/*
    하샤드 수 = 자릿수의 합으로 나누어 떨어지는 수
    수 하나를 입력받아 하샤드 수인지 검증하는 함수 만들기
 */

public class Solution_Pro12947 {                            //하샤드 수
    class Solution {
        public boolean solution(int x) {
            int n = x;
            int sum = 0;
            while(n > 0){
                sum += n % 10;
                n = n / 10;
            }

            if(x % sum == 0){
                return true;
            } else{
                return false;
            }
        }
    }
}
