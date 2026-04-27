package SWEA;

/*
    크기가 N인 파스칼의 삼각형을 만들어야 한다.
    파스칼의 삼각형이란 아래와 같은 규칙을 따른다.
    1. 첫 번째 줄은 항상 숫자 1이다.
    2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_SWEA2005 {                        //파스칼의 삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int T = 1; T <= t; T++){
            int n = Integer.parseInt(br.readLine());
            int [][] arr = new int[n][n];

            sb.append("#").append(T).append("\n");
            for(int i = 0; i < n; i++){
                arr[i][0] = 1;
                arr[i][i] = 1;

                for(int j = 1; j < i; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j <= i; j++){
                    sb.append(arr[i][j]);

                    if(j < i){
                        sb.append(" ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
