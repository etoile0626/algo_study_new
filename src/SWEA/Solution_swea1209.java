package SWEA;

/*
    100X100의 2차원 배열이 주어질 때, 각 행의 합, 각 열의 합, 각 대각선의 합 중 최댓값을 구하기.
    *동일한 최댓값이 있을 경우, 하나의 값만.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea1209 {                                //[S/W 문제해결 기본] 2일차 - Sum
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int T = 0; T < 10; T++){
            int t = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int max = 0;
            int sum = 0;

            for(int i = 0; i < 100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //대각선 합
            for(int i = 0; i < 100; i++){
                sum += arr[i][i];
            }
            max = Math.max(max, sum);

            sum = 0;
            for(int i = 0; i < 100; i++){
                sum += arr[i][99-i];
            }
            max = Math.max(max, sum);

            //가로합
            for(int i = 0; i < 100; i++){
                sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += arr[i][j];
                }
                max = Math.max(max, sum);
            }

            //세로 합
            for(int i = 0; i < 100; i++){
                sum = 0;
                for(int j = 0; j < 100; j++){
                    sum += arr[j][i];
                }
                max = Math.max(max, sum);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
