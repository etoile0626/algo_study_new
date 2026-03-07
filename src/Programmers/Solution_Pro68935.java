package Programmers;

/*
    n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 구하기
 */


import java.util.Stack;

public class Solution_Pro68935 {                            //3진법 뒤집기
    class Solution {
        public int solution(int n) {
            int answer = 0;
            int idx = 0;
            Stack<Integer> stack = new Stack<>();

            while(n != 0){
                stack.push(n % 3);
                n = n / 3;
            }

            while(!stack.isEmpty()){
                int num = stack.pop();
                answer += num * Math.pow(3, idx);
                idx++;
            }

            return answer;
        }
    }
}
