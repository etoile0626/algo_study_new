package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    주어지는 영어 문장에서 특정한 문자열의 개수를 반환하기.

 */

public class Solution_swea1213 {                    //[S/W 문제해결 기본] 3일차 - String
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int T = 1; T <= 10; T++){
            int t = Integer.parseInt(br.readLine());
            String find = br.readLine();
            String str = br.readLine();
            int cnt = 0;

            for(int i = 0; i <= str.length()-find.length(); i++){
                String sub = str.substring(i, i+find.length());

                if(sub.equals(find)){
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
