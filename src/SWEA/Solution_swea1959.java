package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    N 개의 숫자로 구성된 숫자열 Ai (i=1~N) 와 M 개의 숫자로 구성된 숫자열 Bj (j=1~M) 가 있다.
    Ai 나 Bj 를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있다.
    *단, 더 긴 쪽의 양끝을 벗어나서는 안 된다.
    서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.
    *N 과 M은 3 이상 20 이하이다
 */

public class Solution_swea1959 {                            //두 개의 숫자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            int[] b = new int[m];
            int max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }


            if(n < m){
                for(int idx = 0; idx <= m-n; idx++) {
                    int num = 0;

                    for (int i = 0; i < n; i++) {
                        num += a[i] * b[i + idx];
                    }

                    max = Math.max(max, num);
                }
            } else{
                for(int idx = 0; idx <= n-m; idx++) {
                    int num = 0;

                    for (int i = 0; i < m; i++) {
                        num += a[i + idx] * b[i];
                    }

                    max = Math.max(max, num);
                }
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
