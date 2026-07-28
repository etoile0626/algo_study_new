package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    주어진 트리를 in-order 형식으로 순회했을때 나오는 단어를 출력하라.
    트리는 완전 이진 트리 형식으로 주어지며, 노드당 하나의 문자만 저장가능.
    정점 정보는 해당 정점의 문자, 해당 정점의 왼쪽 자식, 오른쪽 자식의 정점 번호 순서로 주어진다.
    정점 번호는 1부터 N까지의 정수로 구분된다. 정점 번호를 매기는 규칙은 위 와 같으며, 루트 정점의 번호는 항상 1이다.
 */

public class Solution_swea1231 {                //[S/W 문제해결 기본] 9일차 - 중위순회
    static StringBuilder str;
    static String[] arr;
    static int n;

    private static void inOrder(int node){
        if(node*2 <= n) {
            inOrder(node * 2);
        }

        str.append(arr[node]);

        if(node*2 + 1 <= n) {
            inOrder(node * 2 + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            str = new StringBuilder();
            n = Integer.parseInt(br.readLine());
            arr = new String[n+1];               //완전이진트리
            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());

                int node = Integer.parseInt(st.nextToken());
                arr[node] = st.nextToken();
            }

            inOrder(1);

            sb.append("#").append(t).append(" ").append(str.toString()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
