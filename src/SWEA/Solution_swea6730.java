package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    주어진 장애물에서 올라갈 때의 높이 변화와 내려갈 때의 높이 변화 둘 각각에 대해 가장 높이 변화가 심한 부분을 난이도로 정의.
    장애물들이 주어질 때, 준홍이의 기준으로 난이도가 어떻게 매겨지는지 구하기.
    *올라가는 부분이나 내려가는 부분이 없다면, 0을 출력하면 된다.
 */

public class Solution_swea6730 {                                //장애물 경주 난이도
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int max = 0;
            int min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < n-1; i++){
                int diff = arr[i+1] - arr[i];

                if(diff >= 0){
                    max = Math.max(max, diff);
                } else{
                    min = Math.min(min, diff);
                }
            }

            //변화량이 없으면 0으로
            if(min == Integer.MAX_VALUE){
                min = 0;
            }

            sb.append("#").append(t).append(" ").append(max).append(" ").append(Math.abs(min)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
