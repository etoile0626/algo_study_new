package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    정수 N이 주어졌을 때, N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있는지 판단하라.
    ->소수 판단하기?
 */

public class Solution_swea12004 {                       //구구단 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            boolean flag = false;

            if(n > 81){
                flag = false;
            } else if (n > 10){
                for(int i = 9; i > 1; i--){
                    if(n % i == 0 && n / i <10){
                        flag = true;
                        break;
                    }
                }
            } else{
                flag = true;
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("Yes");
            } else {
                sb.append("No");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
