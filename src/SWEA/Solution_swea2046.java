package SWEA;

/*
    주어진 숫자만큼 # 을 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_swea2046 {                            //스탬프 찍기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            sb.append("#");
        }

        System.out.println(sb.toString());
    }
}
