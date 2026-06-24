package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2019 {                //더블더블
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int prod = 1;
        for(int i = 0; i <= n; i++){
            sb.append(prod).append(" ");
            prod = prod * 2;
        }

        System.out.println(sb.toString());
    }
}
