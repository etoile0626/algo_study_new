package SWEA;

/*
    ① 농장은 크기는 항상 홀수이다. (1 X 1, 3 X 3 … 49 X 49)
    ② 수확은 항상 농장의 크기에 딱 맞는 정사각형 마름모 형태로만 가능하다.
    농장의 크기 N와 농작물의 가치가 주어질 때, 규칙에 따라 얻을 수 있는 수익은 얼마인지 구하여라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2805 {                                                //농작물 수확하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            int[][] arr = new int[n][n];

            for(int i = 0; i < n; i++){
                String str = br.readLine();

                for(int j = 0; j < n; j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }

            int center = n / 2;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    int dist = Math.abs(center - i) + Math.abs(center - j);                         //맨허튼 거리 공식

                    if(dist <= center){
                        sum += arr[i][j];
                    }
                }
            }

            sb.append("#").append(T).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
