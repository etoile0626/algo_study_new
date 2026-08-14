package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    자연수 N와 R가 주어진다. 이 때의 N combination R의 값을 1234567891로 나눈 나머지를  출력하세요.
    *예를들면 N이 4, R이 2라면 4 combination 2는 (4 * 3) / (2 * 1) = 6
 */

public class Solution_swea5607 {                                //[Professional] 조합
    //모듈러 역원에 대해 공부하고 다시 풀기...

    private static long power(long a, long b){                        //모듈러 연산때문에 새로 만든 거듭제곱 함수
        long result = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                result = result * a % 1234567891;
            }

            a = a * a % 1234567891;             //2^2 * 2^2 = 2^4와 같은 원리
            b /= 2;
        }

        return result;
    }

    private static long combination(int n, int r){
        r = Math.min(r, n - r);                 //6C2나 6c4나 같으니까

        long n1 = 1;
        for(int i = n; i > n - r; i--){
            n1 = (n1 * i) % 1234567891;
        }

        long r1 = 1;
        for(int i = r; i > 1; i--){
            r1 = (r1 * i) % 1234567891;
        }

        long c = n1 * power(r1, 1234567891-2) % 1234567891;

        return c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long num = combination(n, r);

            sb.append("#").append(t).append(" ").append(num).append("\n");
        }

        System.out.println(sb.toString());
    }
}
