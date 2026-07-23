package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    월 일로 이루어진 날짜를 2개 입력 받아, 두 번째 날짜가 첫 번째 날짜의 며칠째인지 출력하가.
    *각 달의 마지막 날짜는 다음과 같다.
    1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31
 */

public class Solution_swea1948 {                        //날짜 계산기
    private static int cal(int m , int d){
        int date = 0;

        for(int i = 1; i < m; i++){
            if(i == 2){
                date += 28;
            } else if(i < 8 && i % 2 == 0){
                date += 30;
            } else if(i < 8 && i % 2 == 1){
                date += 31;
            } else if(i >= 8 && i % 2 == 0){
                date += 31;
            } else if(i >= 8 && i % 2 == 1){
                date += 30;
            }
        }

        date += d;

        return date;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            int date = cal(m2, d2) - cal(m1, d1) + 1;

            sb.append("#").append(t).append(" ").append(date).append("\n");
        }

        System.out.println(sb.toString());
    }
}
