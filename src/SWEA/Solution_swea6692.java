package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    다솔이가 다니는 회사는 이번 달부터 월급을 상자에 담아 주기로 했다.
    이 상자에는 pi의 확률로 xi만원이 들어 있다.
    다솔이가 받을 수 있는 월급의 평균은 얼마인지 구해보자.
 */

public class Solution_swea6692 {                        //다솔이의 월급 상자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            double[] probability = new double[n];
            int[] money = new int[n];
            st = new StringTokenizer(br.readLine());



            sb.append("#").append(t).append(" ").append().append("\n");
        }

        System.out.println(sb.toString());
    }
}
