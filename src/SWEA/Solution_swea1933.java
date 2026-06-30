package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea1933 {                            //간단한 N의 약수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
