package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    n개의 정수가 입력으로 주어질 때, 연속된 정수의 합의 최대값 구하기
 */

public class Solution_swea5642 {                    //합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int cur = arr[0];
            int max = arr[0];
            for(int i = 1; i < n; i++){
                cur = Math.max(arr[i], arr[i] + cur);           //arr[i]부터할지, 이어서 연속합할지
                max = Math.max(cur, max);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
