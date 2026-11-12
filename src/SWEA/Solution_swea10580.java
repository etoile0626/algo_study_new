package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    두 전봇대는 높이가 매우 높으며, N개의 팽팽한 전선으로 연결되어 있었다.
    두 전선이 끝점이 같은 경우는 없으나, 교차하는 경우는 있다.
    세 개 이상의 전선이 하나의 점에서 만나지 않는다고 가정하자.
    이 전봇대에는 총 몇 개의 교차점이 있을까?
 */

public class Solution_swea10580 {                           //전봇대
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if((a[i] < a[j] && b[i] > b[j]) || (a[i] > a[j] && b[i] < b[j])){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
