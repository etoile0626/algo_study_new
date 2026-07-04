package SWEA;

import java.util.Scanner;

/*
    두 개의 숫자 N, M이 주어질 때, N의 M 거듭제곱 값을 구하는 프로그램을 재귀호출을 이용하여 구현하기.
    단, Scanner를 제외한 라이브러리 사용 금지
 */

public class Solution_swea1217 {                            //[S/W 문제해결 기본] 4일차 - 거듭 제곱
    private static int pow(int n, int m, int cnt, int prod){
        if(cnt == m){
            return prod;
        }

        return pow(n, m, cnt + 1, prod * n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int T = 0; T < 10; T++){
            int t = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            int num = pow(n, m, 0, 1);

            System.out.println("#" + t + " " + num);
        }
    }
}
