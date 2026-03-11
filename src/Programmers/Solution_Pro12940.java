package Programmers;

public class Solution_Pro12940 {                        //최대공약수와 최소공배수
    class Solution {
        public int gcd(int a, int b){
            while(a % b != 0){
                int tmp = b;
                b = a % b;
                a = tmp;
            }

            return b;
        }

        public int lcm(int a, int b){
            return (a*b) / gcd(a, b);
        }

        public int[] solution(int n, int m) {
            int[] answer = new int[2];

            answer[0] = gcd(n, m);
            answer[1] = lcm(n, m);

            return answer;
        }
    }
}
