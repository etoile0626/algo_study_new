package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    당신은, n명의 사람의 소득이 주어졌을 때 이 중 평균 이하의 소득을 가진 사람들의 수를 출력해야 한다.
 */

public class Solution_swea10505 {                           //소득 불균형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            double avg = 0;
            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                avg += arr[i];
            }

            avg /= n;

            for(int i = 0; i < n; i++) {
                if (arr[i] <= avg) {
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
