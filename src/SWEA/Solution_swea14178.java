package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    차원 수직선 위에 정원이 있다. 모든 정수 1 ≤ i ≤ N 에 대해, 좌표 i에 꽃이 하나씩 심겨 있다. 즉, 좌표 1, 2, …, N에 총 N개의 꽃이 심겨 있다.
    좌표 x에 분무기를 놓았을 경우 닫힌 구간 [x - D, x + D]에 심긴 모든 꽃들에 물을 줄 수 있다.
    N과 D가 주어질 때, 모든 꽃이 한 개 이상의 분무기에서 물을 받을 수 있도록 하기 위해 필요한 최소한의 분무기 수를 구하기.
 */

public class Solution_swea14178 {                           //1차원 정원
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int pos = 1;
            int cnt = 0;

            while(pos <= n){
                cnt++;
                pos += 2*d + 1;
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
