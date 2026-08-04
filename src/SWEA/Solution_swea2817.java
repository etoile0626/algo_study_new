package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하기.
 */

public class Solution_swea2817 {                    //부분 수열의 합
    static int n, k, num;
    static int[] arr;

    private static void dfs(int cnt, int sum){
        if(sum > k){
            return;
        }

        if(cnt == n){
            if(sum == k){
                num++;
            }

            return;
        }

        dfs(cnt + 1, sum + arr[cnt]);
        dfs(cnt + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            num = 0;
            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
