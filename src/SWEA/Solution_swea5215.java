package SWEA;

/*
    민기의 햄버거 재료에 대한 점수와 가게에서 제공하는 재료에 대한 칼로리가 주어졌을 때,
    민기가 좋아하는 햄버거를 먹으면서도 다이어트에 성공할 수 있도록 정해진 칼로리 이하의 조합 중에서 민기가 가장 선호하는 햄버거를 조합해주는 프로그램을 만들어보자.
    *단 여러 재료를 조합하였을 햄버거의 선호도는 조합된 재료들의 맛에 대한 점수의 합으로 결정되고,
    *같은 재료를 여러 번 사용할 수 없으며,
    *햄버거의 조합의 제한은 칼로리를 제외하고는 없다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea5215 {                        //햄버거 다이어트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int T = 0; T < t; T++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(br.readLine());                //재료 갯수
            int l = Integer.parseInt(br.readLine());                //칼로리 한도
            int[][] arr = new int[n][2];

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());

                arr[i][0] = Integer.parseInt(st.nextToken());       //i번째 재료의 맛
                arr[i][1] = Integer.parseInt(st.nextToken());       //i번째 재료의 칼로리
            }


        }
    }
}
