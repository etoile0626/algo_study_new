package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    LCS(= 최장 공통 부분 수열)은 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
    * ACAYKP와 CAPCAK의 LCS는 ACAK
    입력으로 주어지는 두 문자열의 LCS의 '길이' 구하기
    * 문자열은 알파벳 대문자로만, 최대 1000글자
 */

public class Main_BJ9251 {                              //LCS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int n1 = str1.length;
        int n2 = str2.length;

        int[][] dp = new int[n1+1][n2+1];                   //첫번째 문자열의 i번째 길이까지와 두번째 문자열의 j번째 길이까지 고려했을때의 lcs의 길이

        //dp 초기화 (한 쪽 길이가 0이면 무조건 0)
        for(int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][0] = 0;
                dp[0][j] = 0;
            }
        }

        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                //두 문자가 같으면 dp 값 1 증가
                if(str1[i-1] == str2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                //두 문자가 다르면 이전 dp 값 중 더 큰 값 선택
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n1][n2]);
    }
}
