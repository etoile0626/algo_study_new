package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    강 서쪽에 n개, 동쪽에 m개의 게이트가 존재. (n <= m)
    서쪽과 동쪽의 게이트를 연결하려고 할 때, n개의 다리만큼 연결하려고 함.
    이때, 다리를 지을 수 있는 경우의 수를 구하기
 */

public class Main_BJ1010 {                                  //다리 놓기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] dp = new int[n+1];                        //i개의 서쪽 게이트를 m개의 동쪽 게이트와 연결하는 경우의 수

            dp[1] = m;
            for(int i = 2; i <= n; i++){
                dp[i] = dp[i-1] * (m-1) / i;                //i개 만큼 중복이 나오니 i개 만큼 제거
                m--;
            }

            System.out.println(dp[n]);
        }
    }
}
