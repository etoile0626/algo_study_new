package BaekJoon;

import java.util.Scanner;

/*
    45656의 경우, 인접한 모든 자리의 차가 1.
    이런 수를 계단 수라고 지칭할 때, 길이가 n인 계단 수가 총 몇 개 있는지 구하기.
    * 1 <= n <= 100, 정답을 1000000000으로 나눈 나머지를 출력하기
 */

public class Main_BJ10844 {                     //쉬운 계단 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[][] dp = new long[n+1][10];        //i번째 자릿수에 각 자릿값(0~9)에 대한 경우의 수

        //한 자리수는 모두 계단수로 판정
        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++) {
                if(j == 0){                                                     //현재 자리 수가 0이면 이전 자리 수는 무조건 1
                    dp[i][j] = dp[i-1][j+1] % 1000000000;
                } else if(j == 9){                                              //현재 자리 수가 8면 이전 자리 수는 무조건 9
                    dp[i][j] = dp[i-1][j-1] % 1000000000;
                } else {                                                        //그 외는 +1, -1 2가지 경우 존재
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }

            }
        }

        long cnt = 0;
        for(int i = 0; i < 10; i++){
            cnt = (cnt + dp[n][i]) % 1000000000;                                  //출력할때 모듈러 연산 잊지말기
        }
        System.out.println(cnt);
    }
}
