package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    최대 수와 최소 수를 제외한 나머지의 평균값을 출력하기.
    *소수점 첫째 자리에서 반올림한 정수를 출력.
 */

public class Solution_swea1984 {                            //중간 평균값 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int[] arr = new int[10];
            int avg = 0;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for(int i = 1; i < 9; i++){
                avg += arr[i];
            }
            avg = Math.round(((float) avg) / 8);

            sb.append("#").append(t).append(" ").append(avg).append("\n");
        }

        System.out.println(sb.toString());
    }
}
