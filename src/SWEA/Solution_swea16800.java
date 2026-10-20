package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    무한히 많은 행과 열이 있는 곱셈표 위에 서 있다. (i, j)셀에는 정수 ixj 가 적혀 있다. (만약 행과 열이 9개라면 이는 구구단 표와 동일하다.)
    현재 당신의 위치는 셀 (1, 1) 이다.
    당신은 곱셈표의 오른쪽이나 아래쪽 방향으로 이동할 수 있다. 즉, 당신이 (i, j)에 서 있다면, (i+1, j)나 (i, j+1)로 이동할 수 있다.
    정수 N이 주어질 때, N이 적혀 있는 어떤 셀에 도착하기 위해서 최소 몇 번 움직여야 하는가?
 */

public class Solution_swea16800 {                               //구구단 걷기
    //다시 풀기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            long n = Long.parseLong(br.readLine());
            long sqrt = (long)Math.sqrt(n);
            long min = Long.MAX_VALUE;

            long a = 0;
            long b = 0;
            for(long i = 1; i <= sqrt; i++){
                if(n % i == 0){
                    a = i;
                    b = n / i;
                    min = Math.min(min, a+b-2);
                }
            }

            sb.append("#").append(t).append(" ").append(min).append("\n");
        }

        System.out.println(sb.toString());
    }
}
