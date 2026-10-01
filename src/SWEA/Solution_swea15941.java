package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    정수 N이 주어질 때, 모든 변의 길이가 N인 가장 넓은 평행사변형의 넓이를 출력하라. 이 넓이는 정수임이 보장된다.
 */

public class Solution_swea15941 {                               //평행사변형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int extent = 0;

            extent = n * n;

            sb.append("#").append(t).append(" ").append(extent).append("\n");
        }

        System.out.println(sb.toString());
    }
}
