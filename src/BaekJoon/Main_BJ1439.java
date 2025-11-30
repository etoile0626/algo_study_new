package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ1439 {                      //뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int zero = 0; // '0' 그룹의 개수
        int one = 0;  // '1' 그룹의 개수

        // 첫 번째 문자에 따라 첫 그룹을 추가
        if (s.charAt(0) == '0') {
            zero++;
        } else {
            one++;
        }

        // 연속된 숫자가 변경될 때마다 그룹 개수 증가
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (s.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
        }

        // 최소 횟수를 출력
        System.out.println(Math.min(zero, one));
    }
}
