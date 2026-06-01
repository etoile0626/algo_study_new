package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    주어진 숫자부터 0까지 순서대로 찍어보세요
 */

public class Solution_swea1545 {                        //거꾸로 출력해 보아요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = n; i >= 0; i --){
            sb.append(i).append(" ");
        }

        System.out.println(sb.toString());
    }
}
