package SWEA;

/*
    10개의 수를 입력 받아, 그 중에서 홀수만 더한 값을 출력하는 프로그램을 작성하라.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea2072 {                //홀수만 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for(int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());

                if(num % 2 == 1){
                    sum += num;
                }
            }

            sb.append("#").append(T).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
