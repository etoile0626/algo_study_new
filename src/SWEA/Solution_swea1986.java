package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea1986 {                    //지그재그 숫자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for(int i = 1; i <= n; i++){
                if(i % 2 == 0){
                    sum -= i;
                } else {
                    sum += i;
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
