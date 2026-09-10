package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    수강생들은 1번에서 N번까지 번호가 매겨져 있고, 어떤 번호의 사람이 제출했는지에 대한 목록을 받은 것이다.
    과제를 제출하지 않은 사람의 번호를 오름차순으로 출력하는 프로그램을 작성하라.
 */

public class Solution_swea5431 {                        //민석이의 과제 체크하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[] arr = new boolean[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < k; i++){
                int num = Integer.parseInt(st.nextToken());
                arr[num] = true;
            }

            sb.append("#").append(t);
            for(int i = 1; i <= n; i++) {
                if(!arr[i]) {
                    sb.append(" ").append(i);
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
