package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    정수 N, M 이 주어질 때, M의 이진수 표현의 마지막 N 비트가 모두 1로 켜져 있는지 아닌지를 판별하기.
    마지막 N개의 비트가 모두 켜져 있다면 ON
    아니면 OFF 를 출력하라.
 */

public class Solution_swea10726 {                           //이진수 표현
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean flag = true;

            for(int i = 0; i < n; i++){
                if(m % 2 != 1){
                    flag = false;
                    break;
                }

                m = m / 2;
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("ON");
            } else{
                sb.append("OFF");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
