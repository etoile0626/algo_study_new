package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    S마켓에서 손님에게 거슬러 주어야 할 금액 N이 입력되면 돈의 최소 개수로 거슬러 주기 위하여 각 종류의 돈이 몇 개씩 필요한지 출력하기.
    S마켓에서 사용하는 돈의 종류는 다음과 같다.
    50,000 원
    10,000 원
    5,000 원
    1,000 원
    500 원
    100 원
    50 원
    10 원
 */

public class Solution_swea1970 {                //쉬운 거스름돈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int[] money = new int[8];

            money[0] = n / 50000;
            n = n % 50000;

            money[1] = n / 10000;
            n = n % 10000;

            money[2] = n / 5000;
            n = n % 5000;

            money[3] = n / 1000;
            n = n % 1000;

            money[4] = n / 500;
            n = n % 500;

            money[5] = n / 100;
            n = n % 100;

            money[6] = n / 50;
            n = n % 50;

            money[7] = n / 10;

            sb.append("#").append(t).append("\n");
            sb.append(money[0]).append(" ").append(money[1]).append(" ").append(money[2]).append(" ")
                    .append(money[3]).append(" ").append(money[4]).append(" ").append(money[5]).append(" ")
                    .append(money[6]).append(" ").append(money[7]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
