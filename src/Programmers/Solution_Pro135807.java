package Programmers;

/*
    숫자가 하나씩 적힌 카드들을 절반씩 나눠서 가진 후, 다음 두 조건 중 '하나'를 만족하는 가장 큰 양의 정수 a의 값 구하기.
    1. 철수가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 영희가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
    2. 영희가 가진 카드들에 적힌 모든 숫자를 나눌 수 있고, 철수가 가진 카드들에 적힌 모든 숫자들 중 하나도 나눌 수 없는 양의 정수 a
    *조건을 만족하는 a가 없다면, 0을 return하기.
 */

public class Solution_Pro135807 {                       //숫자 카드 나누기
    class Solution {
        public int gcd(int a, int b){
            if(b == 0){
                return a;
            }

            return gcd(b, a % b);
        }

        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;
            int a = arrayA[0];
            int b = arrayB[0];
            int n = arrayA.length;

            for(int i = 0; i < n; i++){
                a = gcd(arrayA[i], a);
                b = gcd(arrayB[i], b);
            }

            for(int i = 0; i < n; i++){
                if(b != 0 && arrayA[i] % b == 0){
                    b = 0;
                }

                if(a != 0 && arrayB[i] % a == 0){
                    a = 0;
                }
            }

            answer = Math.max(a, b);

            return answer;
        }
    }
}
