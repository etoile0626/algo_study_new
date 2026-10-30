package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    학습지에는 길이 N의 알파벳 대소문자로만 이루어진 문자열이 주어지는데, 석찬이는 "대소문자를 제대로 구분해서" 이 문자열을 받아 적어야 한다.
    석찬이는 N 개의 문자를 받아 적는 데는 성공했지만, 틀리게 적은 문자들이 몇 개 보인다.
    석찬이가 몇 개의 문자를 올바르게 받아 적었는지 세어보자.
 */

public class Solution_swea9317 {                            //석찬이의 받아쓰기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            String str1 = br.readLine();
            String str2 = br.readLine();
            int cnt = 0;

            for(int i = 0; i < n; i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    cnt++;
                }
            }

            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }
}
