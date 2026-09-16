package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea4406 {                                        //모음이 보이지 않는 사람
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();

            str = str.replaceAll("[aeiou]", "");

            sb.append("#").append(t).append(" ").append(str).append("\n");
        }

        System.out.println(sb.toString());
    }
}
