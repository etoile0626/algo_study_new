package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
   퇴사를 하려고 하는데 n + 1일째 되는 날 퇴사를 하기 위해서, 남은 n일 동안 최대한 많은 상담을 하려고 함
    각 상담을 완료하는데 t만큼 소요, p만큼 금액을 받음
    상담을 진행했을 때 얻을 수 있는 최대 수익 구하기
 */

public class Main_BJ14501 {                 //퇴사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] t = new int[n];
        int[] p = new int[n];
        int[] dp = new int[n+1];                           //i번째 날 돈을 벌 수 있는 최댓값

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            if(i + t[i] <= n){                                                  //i번째 날에 일을 해도 기간이 안 넘으면
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);            //일을 한 경우과 안 한 경우 중 최댓값 갱신
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);                                 //현재 누적값과 다음 누적값 비교
        }

        System.out.println(dp[n]);
    }
}
