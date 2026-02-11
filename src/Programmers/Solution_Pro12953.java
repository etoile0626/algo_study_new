package Programmers;

/*
    n개의 수들의 배수 중 공통이되는 최소의 수 찾기
 */

public class Solution_Pro12953 {                                            //N개의 최소공배수
    class Solution {
        //최소공배수
        public int lcm(int a, int b){
            return (a * b) / gcd(a, b);
        }

        //최대공약수
        public int gcd(int a, int b){
            while(b != 0){
                int tmp = a % b;
                a = b;
                b = tmp;
            }

            return a;
        }

        public int solution(int[] arr) {
            int answer = arr[0];
            int n = arr.length;

            for(int i = 1; i < n; i++){
                answer = lcm(answer, arr[i]);
            }

            return answer;
        }
    }
}
