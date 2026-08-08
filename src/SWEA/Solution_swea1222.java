package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    문자열로 이루어진 계산식이 주어질 때, 이 계산식을 후위 표기식으로 바꾸어 계산하기.
    * 연산자는 +만 존재, 숫자는 0 ~ 9의 정수만.
 */

public class Solution_swea1222 {                //[S/W 문제해결 기본] 6일차 - 계산기1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= 10; t++){
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int sum = 0;

            for(int i = 0; i < len; i++){
                char c = str.charAt(i);

                if(c != '+'){
                    sum += (c - '0');
                }
            }

            sb.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(sb.toString());
    }
}
