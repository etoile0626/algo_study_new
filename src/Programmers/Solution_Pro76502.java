package Programmers;

/*
    1. (), [], {} 는 모두 올바른 괄호 문자열.
    2. 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열.
    3. 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열.
    ex) {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열
    위의 조건을 만족할 때, 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때 s가 올바른 괄호 문자열이 되게 하는 x의 개수 구하기
 */

import java.util.Stack;

public class Solution_Pro76502 {                                //괄호 회전하기
    class Solution {
        // 올바른 괄호인지 검사하는 함수
        private boolean verification(String s) {
            // 괄호를 저장할 스택
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                // 여는 괄호면 스택에 push
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else {
                    // 스택이 비어있는 경우
                    if (stack.isEmpty()) {
                        return false;
                    }

                    // 짝이 맞는 괄호면 스택에서 pop
                    if (stack.peek() == '(' && s.charAt(i) == ')')  {
                        stack.pop();
                    } else if (stack.peek() == '{' && s.charAt(i) == '}') {
                        stack.pop();
                    } else if (stack.peek() == '[' && s.charAt(i) == ']') {
                        stack.pop();
                        // 짝이 맞지 않는 경우 false
                    } else return false;
                }
            }

            return stack.isEmpty();
        }

        public int solution(String s) {
            // 올바른 괄호 문자열의 개수를 저장할 변수
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                // 주어진 문자열이 올바른 괄호 문자열인지 검사
                if (verification(s)) {
                    answer++;
                }

                // 문자열을 한 칸씩 회전
                s = s.substring(1) + s.charAt(0);
            }

            return answer;
        }
    }
}
