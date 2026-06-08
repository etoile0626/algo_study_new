package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N x N 행렬이 주어질 때,
    시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하기.
    (3 <= n <= 7)
 */

public class Solution_swea1961 {                            //숫자 배열 회전
    // 최적화 가능한가?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //정답 배열 초기화
            String[] arr90 = new String[n];
            String[] arr180 = new String[n];
            String[] arr270 = new String[n];
            for(int i = 0; i < n; i++){
                arr90[i] = "";
                arr180[i] = "";
                arr270[i] = "";
            }

            //90도
            for(int i = 0; i < n; i++){
                for(int j = n-1; j >= 0; j--){
                    arr90[i] += arr[j][i];
                }
            }

            //180도
            int idx = 0;
            for(int i = n-1; i >= 0; i--){
                for(int j = n-1; j >= 0; j--){
                    arr180[idx] += arr[i][j];
                }

                idx++;
            }

            //270도
            idx = 0;
            for(int i = n-1; i >= 0; i--){
                for(int j = 0; j < n; j++){
                    arr270[idx] += arr[j][i];
                }

                idx++;
            }

            sb.append("#").append(t).append("\n");
            for(int i = 0; i < n; i++){
                sb.append(arr90[i]).append(" ").append(arr180[i]).append(" ").append(arr270[i]).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
