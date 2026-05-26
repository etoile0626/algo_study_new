package SWEA;

/*
    연월일 순으로 구성된 8자리의 날짜의 유효성을 판단한 후, 날짜가 유효하다면
    ”YYYY/MM/DD”형식으로 출력하고,
    날짜가 유효하지 않을 경우, -1 을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2056 {                        //연월일 달력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            String str = br.readLine();
            StringBuffer date = new StringBuffer(str);
            String answer = "-1";

            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6));

            boolean flag = false;

            if(month >= 1 && month <= 12){
                if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                    if(day >= 1 && day <= 31){
                        flag = true;
                    }
                } else if (month == 2) {
                    if(day >= 1 && day <= 28){
                        flag = true;
                    }
                } else{
                    if(day >= 1 && day <= 30){
                        flag = true;
                    }
                }
            }

            if(flag){
                date.insert(4, "/");
                date.insert(7, "/");
                answer = date.toString();
            }

            sb.append("#").append(T).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
