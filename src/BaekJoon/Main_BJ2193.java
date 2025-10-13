package BaekJoon;

import java.util.Scanner;

/*
    0과 1로만 이루어진 수 = 이진수
    이친수 = 이진수들 중 0으로 시작하지 않고 11을 부분 문자열로 가지지 않는(=1이 두번 연속 나타나지 않는) 수
    n이 주어질때, n 자리 이친수의 개수 구하기
 */

public class Main_BJ2193 {                  //이친수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] dp = new long[n+1];        //i자리 수일때 이친수
        dp[1] = 1;                      //1
        //dp[2] = 1;                      //10

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];      //맨 끝자리가 0인 경우 + 맨 끝자리가 1인 경우
        }

        System.out.println(dp[n]);
    }
}
