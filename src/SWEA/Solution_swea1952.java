package SWEA;

/*
    수영장에서 판매하고 있는 이용권은 아래와 같이 4 종류이다.
   ① 1일 이용권 : 1일 이용이 가능하다.
   ② 1달 이용권 : 1달 동안 이용이 가능하다. 1달 이용권은 매달 1일부터 시작한다.
   ③ 3달 이용권 : 연속된 3달 동안 이용이 가능하다. 3달 이용권은 매달 1일부터 시작한다.
       *11월, 12월에도 3달 이용권을 사용할 수 있다.
       *다음 해의 이용권만을 구매할 수 있기 때문에 3달 이용권은 11월, 12월, 1윌 이나 12월, 1월, 2월 동안 사용하도록 구매할 수는 없다.
   ④ 1년 이용권 : 1년 동안 이용이 가능하다. 1년 이용권은 매년 1월 1일부터 시작한다.
    각 이용권의 요금과 각 달의 이용 계획이 입력으로 주어질 때,
    가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고 그 비용을 정답으로 출력하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1952 {                        //[모의 SW 역량테스트] 수영장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            int[] tikects = new int[4];         //0-1일, 1-1달, 2-3달, 3-1년
            int[] years = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++){
                tikects[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++){
                years[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[13];                         //i월까지 가장 적은 비용으로 수영장을 이용할 수 있는 최저 가격
            dp[1] = Math.min(Math.min(tikects[0]*years[1], tikects[1]), Math.min(tikects[2], tikects[3]));
            dp[2] = Math.min(Math.min(dp[1] + tikects[0]*years[2], dp[1] + tikects[1]), Math.min(tikects[2], tikects[3]));
            dp[3] = Math.min(Math.min(dp[2] + tikects[0]*years[3], dp[2] + tikects[1]), Math.min(tikects[2], tikects[3]));
            for(int i = 4; i <= 12; i++){
                dp[i] = Math.min(Math.min(dp[i-1] + tikects[0]*years[i], dp[i-1] + tikects[1]), Math.min(dp[i-3] + tikects[2], tikects[3]));
            }

            sb.append("#").append(T).append(" ").append(dp[12]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
