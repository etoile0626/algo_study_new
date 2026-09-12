package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    N이 주어질 때, 원점을 중심으로 반지름이 N인 원 안에 포함되는 격자점(x,y 좌표가 모두 정수인 점)의 개수를 구하는 프로그램을 작성하라.
    다시 말하자면, x2+y2<=N2인 격자점의 개수를 구하는 프로그램을 작성하라.
 */

public class Solution_swea16910 {                       //원 안의 점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for(int i = -n; i <= n; i++){
                for(int j = -n; j <= n; j++){
                    if(i*i + j*j <= n*n){
                        cnt++;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
