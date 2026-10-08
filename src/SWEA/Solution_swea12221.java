package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    아기 석환이는 최근 구구단을 배웠다. 그래서 1 이상 9 이하의 자연수 두개를 곱셈할 수 있으나, 10 이상의 자연수를 곱셈하는 방법은 모른다.
    두 정수 A, B가 주어진다. 아기 석환이 두 정수를 곱셈할 수 있으면 곱을 출력하고, 아니면 -1을 출력하라.
 */

public class Solution_swea12221 {                           //구구단2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int num = 0;

            if(a > 9 || b > 9){
                num = -1;
            } else {
                num = a * b;
            }

            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
