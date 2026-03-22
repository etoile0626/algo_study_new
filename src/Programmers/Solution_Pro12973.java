package Programmers;

/*
     문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
     이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료될 때,
     주어진 문자열이 제거할 수 있는 문자열인지 구하는 함수 만들기.
     *수행할 수 있으면 1을, 아닐 경우 0
 */

import java.util.Stack;

public class Solution_Pro12973 {                            //짝지어 제거하기
    class Solution{
        public int solution(String s)
        {
            int answer = 1;
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++){
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                } else{
                    char c = s.charAt(i);

                    if(c == stack.peek()){
                        stack.pop();
                    } else{
                        stack.push(c);
                    }
                }
            }

            if(stack.isEmpty()){
                answer = 1;
            } else{
                answer = 0;
            }

            return answer;
        }
    }
}
