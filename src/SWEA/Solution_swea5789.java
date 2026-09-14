package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    1번부터 N번까지 N개의 상자를 가지고 있다. 각 상자에는 숫자를 새길 수 있는데 처음에는 모두 0으로 적혀있다.
    숫자가 너무 단조로웠던 현주는 다음 Q회 동안 일정 범위의 연속한 상자를 동일한 숫자로 변경하려고 한다. 변경하는 방법은 다음과 같다.
       ·  i (1 ≤ i ≤ Q)번째 작업에 대해 L번 상자부터 R번 상자까지의 값을 i로 변경
    현주가 Q회 동안 위의 작업을 순서대로 한 다음 N개의 상자에 적혀있는 값들을 순서대로 출력하기.
 */

public class Solution_swea5789 {                //현주의 상자 바꾸기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            for(int i = 1; i <= q; i++){
                st = new StringTokenizer(br.readLine());
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                for(int j = l-1; j < r; j++){
                    arr[j] = i;
                }
            }

            sb.append("#").append(t);
            for(int i = 0; i < n; i++) {
                sb.append(" ").append(arr[i]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
