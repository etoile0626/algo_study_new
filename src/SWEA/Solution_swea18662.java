package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    세 정수 a,b,c가 주어진다. 당신은 음이 아닌 실수 x을 정한 뒤, 세 정수 중 하나에서 x만큼을 더하거나 뺄 수 있다. 당신은 이러한 작업을 정확히 한 번 하여 a,b,c가 등차수열을 이루도록 하려고 한다.
    이것이 가능하도록 하는 가장 작은 x의 값이 얼마인지 구하기.
 */

public class Solution_swea18662 {                           //등차수열 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];

            for(int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            double x = Math.abs(((double) (arr[0] + arr[2]) / 2) - arr[1]);

            sb.append("#").append(t).append(" ").append(String.format("%.1f", x)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
