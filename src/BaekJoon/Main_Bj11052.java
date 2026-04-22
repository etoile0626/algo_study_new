package BaekJoon;

/*
    카드는 카드팩의 형태로만 구입 가능, 카드가 1개~ n개가 포함된 카드팩 총 N가지 존재.
    최대한 돈을 많이 지불해 n개의 카드를 구매하고자 함.
    이때 금액의 최댓값을 구하기.
    *구매하는 카드의 개수가 정확히 n개여야 함!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Bj11052 {                             //카드 구매하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        dp[1] = card[1];

        if(n > 1) {
            dp[2] = Math.max(dp[1] + card[1], card[2]);

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
                }
            }
        }

        System.out.println(dp[n]);
    }
}
