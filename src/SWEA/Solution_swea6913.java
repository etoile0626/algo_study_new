package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N명의 사람들이 m개의 문제가 나오는 어떤 프로그래밍 대회에 참가했다.
    각 사람들이 문제를 풀었는지 아닌지를 나타내는 NⅹM 개의 값 Aij를 구할 수 있었다.
    사람에 1에서 N까지의 번호를 붙이고, 문제에도 1에서 M까지의 번호를 붙일 때,
    Aij 는 대회가 끝나고 i번 사람이 j번 문제를 풀었다면 1, 풀지 못했다면 0을 가지는 값이다.
    푼 문제 수가 많은 사람이 더 높은 등수를 가지고, 푼 문제 수가 같은 사람은 같은 등수를 가진다.
    이 대회의 결과를 받아 1등을 한 사람이 몇 명이고 몇 문제를 풀었는지 구하기.
 */

public class Solution_swea6913 {                                //동철이의 프로그래밍 대회
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n+1][m+1];
            int num = 0;
            int sol = 0;

            for(int i = 1; i <= n; i++){
                st = new StringTokenizer(br.readLine());
                int cnt = 0;

                for(int j = 1; j <= m; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if(arr[i][j] == 1){
                        cnt++;
                    }
                }

                if(sol < cnt){
                    sol = cnt;
                }
            }

            for(int i = 1; i <= n; i++){
                int cnt = 0;

                for(int j = 1; j <= m; j++){
                    if(arr[i][j] == 1){
                        cnt++;
                    }
                }

                if(cnt == sol){
                    num++;
                }
            }

            sb.append("#").append(t).append(" ").append(num).append(" ").append(sol).append("\n");
        }

        System.out.println(sb.toString());
    }
}
