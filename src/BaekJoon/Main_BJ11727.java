package BaekJoon;

import java.util.Scanner;

/*
    2*n 직사각형을 1*2, 2*1, 2*2 타일로 채우는 방법의 수를 구하는 프로그램 작성하기
    *이 방법의 수를 10007로 나눈 나머지를 출력할 것
 */

public class Main_BJ11727 {                 //2xN 타일링 2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[n+1];

        dp[1] = 1;                  // 2*1 1개

        if(n > 1) {
            dp[2] = 3;              // 1*2 2개 + 2*1 2개 + 2*2 1개
        }

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2] * 2) % 10007;            //dp[3] = dp[1]에 2*2(=1*2 2개 or 2*2) 크기의 네모 붙이기 + dp[2]에 2*1 크기의 네모 붙이기
        }

        System.out.println(dp[n]);
    }
}
