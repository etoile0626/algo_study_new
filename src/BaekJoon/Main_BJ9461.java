package BaekJoon;

import java.util.Scanner;

/*
    길이가 1인 정삼각형으로 시작해서 나선에서 가장 긴 변의 길이를 k라고 할 때, 길이가 k인 정삼각형을 추가함
    파도반 수열 p(n)이 나선에 있는 정삼각형 변의 길이일때, p(n)을 구하기
 */

public class Main_BJ9461 {                  //파도반 수열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int T = 0; T < t; T++){
            int n = sc.nextInt();

            int[] dp = new int[n+1];

            dp[1] = 1;
            if(n > 2) {
                dp[2] = 1;

                if(n > 3) {
                    dp[3] = 1;
                }
            }

            for(int i = 4; i <= n; i++){
                dp[i] = dp[i-2] + dp[i-3];
            }

            System.out.println(dp[n]);
        }
    }
}
