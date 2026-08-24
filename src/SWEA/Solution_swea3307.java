package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    주어진 두 수열의 최장 증가 부분 수열(Longest Increasing Subsequence)의 길이를 계산하기.
 */

public class Solution_swea3307 {                        //최장 증가 부분 수열
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[n+1];                            //i번째원소까지 포함하여 탐색했을때의 최장 증가 부분 수열의 길이
            for(int i = 1; i <= n; i++){
                dp[i] = 1;                                      //초기화
            }

            for(int i = 1; i < n; i++){
                for(int j = i + 1; j <= n; j++){
                    if(arr[i] <= arr[j]){                       //증가 부분 수열 조건 만족시
                        dp[j] = Math.max(dp[i]+1, dp[j]);
                    }
                }
            }

            int answer = 0;
            for (int i = 1; i <= n; i++) {
                answer = Math.max(answer, dp[i]);
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
