package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    자연수 A가 주어진다. 여기에 자연수 B를 곱한 결과가 거듭제곱수가 되는 최소의 B를 구하기.
    *완벽히 거듭제곱이라기 보단 제곱이 짝수가 되도록해야함
 */

public class Solution_swea10965 {                           //제곱수 만들기
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int a = Integer.parseInt(br.readLine());
            int b = 1;

            // 소인수분해 후 지수가 홀수인 소수만 B에 곱한다
            for(int i = 2; i * i <= a; i++){                        //i = a의 지수
                int cnt = 0;

                while(a % i == 0){
                    a /= i;
                    cnt++;
                }

                if(cnt % 2 == 1) {                                  //지수가 홀수면 정답에 곱해주기
                    b *= i;
                }
            }

            if(a > 1) {
                b *= a;   // 남은 값은 지수가 1인 소수
            }

            sb.append("#").append(t).append(" ").append(b).append("\n");
        }

        System.out.println(sb.toString());
    }
}
