package SWEA;

/*
    패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하기.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2007 {                        //패턴 마다의 길이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++){
            String str = br.readLine();

            for(int i = 1; i <= str.length(); i++){
                String sub1 = str.substring(0, i);
                String sub2 = str.substring(i, i+i);

                if(sub1.equals(sub2)){
                    sb.append("#").append(T).append(" ").append(sub1.length()).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}
