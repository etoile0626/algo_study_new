package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    시 분으로 이루어진 시각을 2개 입력 받아, 더한 값을 시 분으로 출력하는 프로그램을 작성하라.
    (시각은 12시간제로 표시한다. 즉, 시가 가질 수 있는 값은 1시부터 12시이다.)
 */

public class Solution_swea1976 {                        //시각 덧셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int sum_h = h1 + h2;
            int sum_m = m1 + m2;

            if(sum_m >= 60){
                sum_h += 1;
                sum_m = (sum_m % 60);
            }

            sum_h = (sum_h % 12);

            if(sum_h == 0){
                sum_h = 12;
            }

            sb.append("#").append(t).append(" ").append(sum_h).append(" ").append(sum_m).append("\n");
        }

        System.out.println(sb.toString());
    }
}
