package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n*n개의 수가 있을 때 (x1, y1)에서 (x2, y2)까지의 합을 구하기
    합을 구해야하는 횟수 m, x1 <= x2, y1 <= y2
 */

public class Main_BJ11660 {                 //구간 합 구하기 5
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n+1][n+1];                     //(1, 1)부터 (i, j)까지의 구간 합

        dp[1][1] = arr[1][1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];          //이전 행, 열 까지의 합 - 겹치는 부분 + 이번 배열 값
            }
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            //dp 구하는 거랑 비슷한 느낌으로
            //전체 범위에서 x2행 y1-1열 구간합, x1-1행 y2열 구간합 제거 후 중복으로 뺀 x1-1행 y1-1열 구간합 더해주기? 그림으로 그려서 참고하기
            System.out.println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
        }
    }
}
