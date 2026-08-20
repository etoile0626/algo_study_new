package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    사칙연산 “+, -, *, /”와 양의 정수로만 구성된 임의의 이진 트리가 주어질 때, 이를 계산한 결과를 출력하기.
    *계산 중간 과정에서의 연산은 모두 실수 연산
    *결과값은 소수점 아래는 버리고 정수로 출력.
    *정점이 정수면 정점 번호와 양의 정수가 주어지고, 정점이 연산자이면 정점 번호, 연산자, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점 번호가 차례대로 주어진다.
    *정점 번호는 1부터 N까지의 정수로 구분된고 루트 정점의 번호는 항상 1이다.
 */

public class Solution_swea1232 {                            //[S/W 문제해결 기본] 9일차 - 사칙연산
    //이진트리 자료구조 구현에 신경쓰며 다시 풀기.

    //이진트리 구현 클래스
    static class Node {
        String value;
        Node left;
        Node right;
    }

    private static double postOrder(Node root){             //연산자 계산을 위한 후위 순회
        double result = 0;
        if(root.value.equals("+") || root.value.equals("-") || root.value.equals("*") || root.value.equals("/")){
            double left = postOrder(root.left);
            double right =  postOrder(root.right);

            if(root.value.equals("+")) {
                result = left + right;
            } else if(root.value.equals("-")) {
                result = left - right;
            } else if(root.value.equals("*")) {
                result = left * right;
            } else if(root.value.equals("/")) {
                result = left / right;
            }
        } else{
            return Double.parseDouble(root.value);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int n = Integer.parseInt(br.readLine());
            Node[] arr = new Node[n+1];

            for(int i = 1; i <= n; i++){
                arr[i] = new Node();
            }

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                arr[num].value = st.nextToken();

                if(st.hasMoreTokens()){                 //value가 연산자라 입력할 토큰이 더 있다면 처리
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());

                    arr[num].left = arr[left];
                    arr[num].right = arr[right];
                }
            }

            int result = (int)postOrder(arr[1]);

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }
}
