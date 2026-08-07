package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
    문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하는 프로그램을 작성하시오.
    문자열 계산식을 구성하는 연산자는 +, * 두 종류이며 피연산자인 숫자는 0 ~ 9의 정수만 주어진다.
 */

public class Solution_swea1223 {                //[S/W 문제해결 기본] 6일차 - 계산기2
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();                                 //중위계산식
            StringBuilder postfix = new StringBuilder();                //후위계산식
            Stack<Character> stack1 = new Stack<>();                    //연산자 순서 들어가는 스택

            for(int i = 0; i < len; i++){
                char c = str.charAt(i);

                if(c == '+'){
                    //다음 들어갈 연산자가 +면 스택에 있던 연산자들(+보다 높은 우선순위의 연산자들)을 계산식에 넣어두기
                    while(!stack1.isEmpty()){
                        postfix.append(stack1.pop());
                    }

                    stack1.push(c);
                }
                else if(c == '*'){
                    //다음 연산자가 *이면 기존에 들어있던 *를 먼저 계산식에 삽입(같은 우선순위)
                    while (!stack1.isEmpty() && stack1.peek() == '*'){
                        postfix.append(stack1.pop());
                    }

                    stack1.push(c);
                }
                //숫자는 그냥 계산식에 바로 넣기
                else{
                    postfix.append(c);
                }
            }

            //남아있는 스택의 연산자들 후위계산식에 추가
            while(!stack1.isEmpty()){
                postfix.append(stack1.pop());
            }

            //후위계산식 계산
            Stack<Integer> stack2 = new Stack<>();
            for(int i = 0; i < postfix.length(); i++){
                char c = postfix.charAt(i);

                if(c == '+'){
                    stack2.push(stack2.pop() + stack2.pop());
                } else if(c == '*'){
                    stack2.push(stack2.pop() * stack2.pop());
                } else {
                    stack2.push(c-'0');
                }
            }

            int cal = stack2.pop();
            sb.append("#").append(t).append(" ").append(cal).append("\n");
        }

        System.out.println(sb.toString());
    }
}
