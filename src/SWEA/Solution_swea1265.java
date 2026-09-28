package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    10개의 달란트를 모은 원생에게 10개의 사탕을 나누어 주는 것이 아니라 10개를 3 묶음으로 나누어서 각 묶음의 곱의 개수로 사탕을 교환해 주기로 했다.
    10 달란트를 3묶음으로 나눌 경우 어떻게 나누어야 가장 많은 사탕을 교환할 수 있을까?
    *예를 들어 1개, 1개, 8개 묶음으로 나누면 1x1x8=8 로 8개의 사탕과 교환할 수 있다.
    *최대는 3x3x4=36으로 36개의 사탕과 교환할 수 있다.
    *원생마다 달란트의 개수가 다르며 원장님은 서로 다른 묶음 개수를 제시하기로 했다.
    달란트 수와 묶음의 수가 주어질 때 받을 수 있는 사탕의 최대 개수를 구하기.
 */

public class Solution_swea1265 {                            //[S/W 문제해결 응용] 9일차 - 달란트2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            int num = n / p;
            int mod = n % p;

            long answer = 1;

            for(int i = 0; i < mod; i++){       //Math.pow(num+1, mod);
                answer *= num+1;
            }

            for(int i = 0; i < p-mod; i++){     //Math.pow(num, p-mod);
                answer *= num;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
