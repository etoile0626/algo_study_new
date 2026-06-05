package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    두 회사 중 더 적게 수도 요금을 부담해도 되는 회사를 고르려고 한다.
    A사 : 1리터당 P원의 돈을 내야 한다.
    B사 : 기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금만 청구된다.
    *하지만 R 리터보다 많은 양을 사용한 경우 초과량에 대해 1리터당 S원의 요금을 더 내야 한다.
    한 달간 사용하는 수도의 양이 W리터라고 할 때, 요금이 더 저렴한 회사를 골라 그 요금을 출력하기.
    *(1 ≤ P, Q, R, S, W ≤ 10000, 자연수)
 */

public class Solution_swea1284 {                    //수도 요금 경쟁
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int charge = 0;

            int a = p * w;
            int b = q;

            if(w > r){
                b += (w-r) * s;
            }

            charge = Math.min(a, b);

            sb.append("#").append(t).append(" ").append(charge).append("\n");
        }

        System.out.println(sb.toString());
    }
}
