package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    숫자 N은 아래와 같다.
    N=2^a x 3^b x 5^c x 7^d x 11^e
    N이 주어질 때 a, b, c, d, e 를 출력하라.
 */

public class Solution_swea1945 {                    //간단한 소인수분해
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int a = 0, b = 0, c = 0, d =0, e = 0;

            while(n > 1){
                if(n % 2 == 0){
                    n /= 2;
                    a++;
                } else if (n % 3 == 0) {
                    n /= 3;
                    b++;
                } else if (n % 5 == 0) {
                    n /= 5;
                    c++;
                } else if (n % 7 == 0) {
                    n /= 7;
                    d++;
                } else if (n % 11 == 0) {
                    n /= 11;
                    e++;
                }
            }

            sb.append("#").append(t).append(" ")
                    .append(a).append(" ").append(b).append(" ")
                    .append(c).append(" ").append(d).append(" ")
                    .append(e).append("\n");
        }

        System.out.println(sb.toString());
    }
}
