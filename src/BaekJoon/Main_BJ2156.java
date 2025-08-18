package BaekJoon;

import java.util.Scanner;

/*
    2가지 규칙에 따라 포도주를 시식하고자 함.
    1. 포도주 잔을 선택하면 그 포도주 잔은 다 마셔야하고, 마신 후에는 원 위치에 둘 것.
    2. 연속으로 놓인 3잔은 마실 수 없음
    1부터 n까지 번호가 붙은 n개의 포도주 잔이 순서대로 테이블에 있고, 각 포도주의 양이 주어질 때, 가장 많은 양의 포도주를 마시기
 */

public class Main_BJ2156 {                                  //포도주 시식
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        long[][] dp = new long[n+1][3];                         //0 - 이번 잔을 안 마심 / 1 - 직전은 안 먹고 이번은 마심 / 2 - 2잔을 연속으로 마심(이번 + 직전)

        dp[1][0] = 0;
        dp[1][1] = arr[1];
        dp[1][2] = arr[1];

        //점화식 도출 과정, 다시 공부해보기
//        dp[2][0] = arr[1];
//        dp[2][1] = arr[2];
//        dp[2][2] = arr[1] + arr[2];
//
//        dp[3][0] = Math.max(Math.max(dp[2][0], dp[2][1]), dp[2][2]);
//        dp[3][1] = dp[2][0] + arr[3];
//        dp[3][2] = dp[2][1] + arr[3];

        for(int i = 2; i <= n; i++){
            dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
            dp[i][1] = dp[i-1][0] + arr[i];
            dp[i][2] = dp[i-1][1] + arr[i];
        }

        System.out.println(Math.max(Math.max(dp[n][0], dp[n][1]), dp[n][2]));
    }
}
