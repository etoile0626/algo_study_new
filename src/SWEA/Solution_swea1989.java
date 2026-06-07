package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
    단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하기.
 */

public class Solution_swea1989 {                    //초심자의 회문 검사
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            int n = str.length();
            int flag = 1;

            for(int i = 0; i < n/2; i++){
                if(str.charAt(i) != str.charAt(n-i-1)){
                    flag = 0;
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(flag).append("\n");
        }

        System.out.println(sb.toString());
    }
}
