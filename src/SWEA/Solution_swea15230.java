package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    성훈이가 적은 알파벳을 순서대로 보면서 앞에서부터 몇 개의 알파벳이 순서에 맞게 적혀 있는지 구하는 프로그램을 작성하라.
    *단, 순서는 a부터 순서대로 일치하는 알파벳 개수를 계산하여야 한다.
 */

public class Solution_swea15230 {                   //알파벳 공부
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            String answer = "abcdefghijklmnopqrstuvwxyz";
            int cnt = 0;

            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == answer.charAt(i)){
                    cnt++;
                } else{
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
