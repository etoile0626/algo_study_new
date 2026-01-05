package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ2740 {              //행렬 곱셈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // A행렬 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] A = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        st = new StringTokenizer(br.readLine());

        // B행렬 입력
        m = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[m][K];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < K; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 행렬 계산 및 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < K; j++) {
                int sum = 0;
                for(int k = 0; k < m; k++) {
                    sum += A[i][k] * B[k][j];
                }
                // A의 i행의 j열 연산이 끝나면 바로 출력문으로 보내준다.
                sb.append(sum).append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}
