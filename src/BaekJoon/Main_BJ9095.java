package BaekJoon;

import java.util.Scanner;

/*
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수 구하기
    * 0 < n < 11
 */

public class Main_BJ9095 {                              //1, 2, 3 더하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int t = 0; t < T; t++){
            int n = sc.nextInt();

            int[] dp = new int[n+1];                    //i를 만들 수 있는 방법의 수

            dp[1] = 1;
            if(n > 1){
                dp[2] = 2;

                if(n > 2){
                    dp[3] = 4;
                }
            }
            for(int i = 4; i <= n; i++){
                dp[i] = dp[i-1] + dp[i-2] +dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
