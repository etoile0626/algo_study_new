package SWEA;

/*
    n*n 배열에 파리가 있을 때, m*m크기의 파리채로 파리를 죽이고자 함.
    이때, 죽일 수 있는 파리의 최대 수를 구하라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea2001 {                            //파리 퇴치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];
            int max = 0;

            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n ; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int r = 0; r <= n - m; r++) {
                for (int c = 0; c <= n - m; c++) {
                    int sum = 0;
                    for (int i = r; i < r + m; i++) {
                        for (int j = c; j < c + m; j++) {
                            sum += arr[i][j];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
