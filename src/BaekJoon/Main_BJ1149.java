package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    1번부터 n번까지 집이 순서대로 있을때, 집을 빨강, 초록, 파랑 중 하나의 색으로 칠해야한다.
    각 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어질 때 아래 규칙을 만족하며 모든 집을 칠하는 비용의 최솟 값 구하기
    *1번과 2번집은 다른 색
    *n번 집은 n-1번 집과 다른 색
    *i번째 집은 i+1, i-1 번집과 다른 색 (2 <= i <= n-1)
 */

public class Main_BJ1149 {                          //RGB거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n  = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];                   // 0-red / 1-green / 2-blue

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            if(i == 1){
                dp[i][0] = red;
                dp[i][1] = green;
                dp[i][2] = blue;
            } else{
                dp[i][0] = Math.min(dp[i-1][1] + red, dp[i-1][2] + red);
                dp[i][1] = Math.min(dp[i-1][0] + green, dp[i-1][2] + green);
                dp[i][2] = Math.min(dp[i-1][0] + blue, dp[i-1][1] + blue);
            }
        }

        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }
}
