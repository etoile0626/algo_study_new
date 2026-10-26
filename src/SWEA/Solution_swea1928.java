package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

/*
    입력으로 Base64 Encoding 된 String 이 주어졌을 때, 해당 String 을 Decoding 하여, 원문을 출력하는 프로그램을 작성하시오.
    *문자열의 길이는 항상 4의 배수로 주어진다. 그리고 문자열의 길이는 100000을 넘지 않는다.
 */

public class Solution_swea1928 {                        //Base64 Decoder
    //다시 풀기. 라이브러리 쓰면 금방이네..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            byte[] arr = Base64.getDecoder().decode(str);
            String decode = new String(arr);

            sb.append("#").append(t).append(" ").append(decode).append("\n");
        }

        System.out.println(sb.toString());
    }
}
