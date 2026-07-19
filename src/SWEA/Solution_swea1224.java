package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하기.
    *문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 문자열 중간에 괄호가 들어갈 수 있음.
    *숫자는 0 ~ 9의 정수만.
    ex)“3+(4+5)*6+7” -> "345+6*+7+" = 64
 */

public class Solution_swea1224 {                            //[S/W 문제해결 기본] 6일차 - 계산기3
    //다시 풀기 (계산식 변환에서 시행착오 줄이기)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int len = Integer.parseInt(br.readLine());                   //계산식 길이
            String infix = br.readLine();                                  //중위계산식

            StringBuilder postfix = new StringBuilder();                //후위계산식
            Stack<Character> stack1 = new Stack<>();                    //연산자 순서 들어가는 스택

            //계산식 변환
            for(int i = 0; i < len; i++){
                char c = infix.charAt(i);

                if(c == '('){
                    stack1.push(c);
                }
                else if (c == '+') {
                    // +보다 우선순위가 높거나 같은 연산자('('가 나오기 전까지의 모든 연산자)를 먼저 계산식에 넣어처리
                    while (!stack1.isEmpty() && stack1.peek() != '(') {
                        postfix.append(stack1.pop());
                    }
                    stack1.push(c);

                }
                else if (c == '*') {
                    // 같은 우선순위인 기존 *를 먼저 처리
                    while (!stack1.isEmpty() && stack1.peek() == '*') {
                        postfix.append(stack1.pop());
                    }
                    stack1.push(c);
                }
                else if(c == ')') {
                    while(stack1.peek() != '('){                        //'('전까지 있단 연산자 계산식에 추가
                        postfix.append(stack1.pop());
                    }

                    stack1.pop();                                       //'('제거
                }
                else {                //숫자처리
                    postfix.append(c);
                }
            }
            //남아있는 스택의 연산자들 후위계산식에 추가
            while(!stack1.isEmpty()){
                postfix.append(stack1.pop());
            }

            //계산
            Stack<Integer> stack2 = new Stack<>();                       //후위계산식 돌면서 숫자 담을 스택
            for(int i = 0; i < postfix.length(); i++){
                char c = postfix.charAt(i);

                if(c == '+'){
                    stack2.push(stack2.pop() + stack2.pop());
                } else if(c == '*'){
                    stack2.push(stack2.pop() * stack2.pop());
                } else {
                    stack2.push(c - '0');
                }
            }

            int result = stack2.pop();
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
