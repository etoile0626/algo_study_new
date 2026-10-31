package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea5549 {                        //홀수일까 짝수일까
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int n = str.charAt(str.length()-1) - '0';
            boolean flag = false;

            if(n % 2 != 0){
                flag = true;
            }

            sb.append("#").append(t).append(" ");
            if(flag){
                sb.append("Odd");
            } else{
                sb.append("Even");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
