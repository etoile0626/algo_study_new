package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2058 {                    //자릿수 더하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int num = 0;

        while(n > 0){
            num += n % 10;

            n = n / 10;
        }

        System.out.println(num);
    }
}
