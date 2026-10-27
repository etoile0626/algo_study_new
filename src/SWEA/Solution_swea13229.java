package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    오늘의 요일을 나타내는 문자열 S가 주어진다. S는 “MON”(월), “TUE”(화), “WED”(수), “THU”(목), “FRI”(금), “SAT”(토), “SUN”(일) 중 하나이다.
    다음 (즉, 내일 이후의 가장 빠른) 일요일까지는 며칠 남았을까?
 */

public class Solution_swea13229 {                               //일요일
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int cnt = 0;

            switch (str){
                case "MON":
                    cnt = 6;
                    break;
                case "TUE":
                    cnt = 5;
                    break;
                case "WED":
                    cnt = 4;
                    break;
                case "THU":
                    cnt = 3;
                    break;
                case "FRI":
                    cnt = 2;
                    break;
                case "SAT":
                    cnt = 1;
                    break;
                default:
                    cnt = 7;
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
