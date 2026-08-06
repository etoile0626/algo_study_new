package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이 식의 유효성을 검사하는 프로그램을 작성하여라.
    여기서 말하는 유효성이란, 사칙연산 “+, -, *, /”와 양의 정수로 구성된 임의의 식이 적절한 식인지를 확인하는 것으로,
    계산이 가능하다면 “1”, 계산이 불가능할 경우 “0”을 출력한다.
    (단, 계산이 가능한지가 아닌 유효성을 검사하는 문제이므로 0으로 나누는 경우는 고려하지 않는다. )
 */

public class Solution_swea1233 {                //[S/W 문제해결 기본] 9일차 - 사칙연산 유효성 검사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            char[] tree = new char[n+1];
            int flag = 1;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);

                tree[node] = c;
            }

            for(int i = 1; i <= n; i++){
                if(i * 2 > n || i * 2 + 1 > n){     //현재 노드의 자식 없다면 (리프노드일때)
                    if(tree[i] == '+' || tree[i] == '-' || tree[i] == '*' || tree[i] == '/'){
                        flag = 0;
                    }
                }
                else {
                    //자식이 있는 노드가 연산자가 아니라면
                    if(tree[i] != '+' && tree[i] != '-' && tree[i] != '*' && tree[i] != '/'){
                        flag = 0;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}
