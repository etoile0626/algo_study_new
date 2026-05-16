package SWEA;

/*
    .
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea2068 {                                //최대수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            int max = 0;
            for(int i = 0; i < 10; i++){
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
            }

            sb.append("#").append(T).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
